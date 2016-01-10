#version 330

const int MAX_POINT_LIGHTS = 4;
const int MAX_SPOT_LIGHTS = 4;

in vec2 vsout_textureCoordinate;
in vec3 vsout_normal;
in vec3 vsout_worldPosition;

out vec4 fsout_fragColor;

struct DirectionalLight
{
    vec3 color;
    float intensity;
    vec3 direction;
};

struct Attenuation
{
    float constant;
    float linear;
    float exponent;
};

struct PointLight
{
    vec3 color;
    float intensity;
    Attenuation attenuation;
    vec3 position;
    float range;
};

struct SpotLight
{
    vec3 color;
    float intensity;
    Attenuation attenuation;
    vec3 position;
    float range;
    vec3 direction;
    float cutoff;
};

uniform vec3 eyePosition;

uniform vec3 baseColor;
uniform sampler2D sampler;
uniform int useTexture;

uniform float specularIntensity;
uniform float specularExponent;

uniform vec3 ambientLight;
uniform DirectionalLight directionalLight;
uniform PointLight pointLights[MAX_POINT_LIGHTS];
uniform SpotLight spotLights[MAX_SPOT_LIGHTS];

vec4 calculateLight(vec3 color, float intensity, vec3 direction, vec3 normal)
{
    float diffuseFactor = dot(normal, -direction);
    
    vec4 diffuseColor = vec4(0, 0, 0, 0);
    vec4 specularColor = vec4(0, 0, 0, 0);
    
    if (diffuseFactor > 0)
    {
        diffuseColor = vec4(color, 1.0) * intensity * diffuseFactor;
        
        vec3 directionToEye = normalize(eyePosition - vsout_worldPosition);
        vec3 reflectDirection = normalize(reflect(direction, normal));
        
        float specularFactor = dot(directionToEye, reflectDirection);
        specularFactor = pow(specularFactor, specularExponent);
        
        if (specularFactor > 0)
        {
            specularColor = vec4(color, 1.0) * specularIntensity * specularFactor;
        }
    }
    
    return diffuseColor + specularColor;
}

vec4 calculateDirectionalLight(DirectionalLight directionalLight, vec3 normal)
{
    return calculateLight(directionalLight.color, directionalLight.intensity, -directionalLight.direction, normal);
}

vec4 calculatePointLight(vec3 color, float intensity, Attenuation attenuation, vec3 position, float range, vec3 normal)
{
    vec3 lightDirection = vsout_worldPosition - position;
    float distanceToPoint = length(lightDirection);
    
    if (distanceToPoint > range)
    {
        return vec4(0, 0, 0, 0);
    }
    
    lightDirection = normalize(lightDirection);
    
    vec4 colorResult = calculateLight(color, intensity, lightDirection, normal);
    
    float attenuationResult = attenuation.constant +
                        attenuation.linear * distanceToPoint +
                        attenuation.exponent * distanceToPoint * distanceToPoint;
    
    if (attenuationResult <= 0)
    {
        attenuationResult = 0.0001;
    }
    
    return colorResult / attenuationResult;
}

vec4 calculateSpotLight(vec3 color, float intensity, Attenuation attenuation, vec3 position, float range, vec3 direction, float cutoff, vec3 normal)
{
    vec3 lightDirection = normalize(vsout_worldPosition - position);
    float spotFactor = dot(lightDirection, direction);
    
    vec4 colorResult = vec4(0, 0, 0, 0);
    
    if (spotFactor > cutoff)
    {
        colorResult = calculatePointLight(color, intensity, attenuation, position, range, normal);
        colorResult = colorResult * (1.0 - (1.0 - spotFactor) / (1.0 - cutoff));
    }
    
    return colorResult;
}

void main()
{
    vec4 color = vec4(baseColor, 1);

    vec4 textureColor = texture(sampler, vsout_textureCoordinate.xy);
    
    if (useTexture == 1)
        color *= textureColor;
    
    vec4 totalLight = vec4(ambientLight, 1);
    
    vec3 normal = normalize(vsout_normal);
    
    totalLight += calculateDirectionalLight(directionalLight, normal);
    
    for (int i = 0; i < MAX_POINT_LIGHTS; i++)
    {
        if (pointLights[i].intensity > 0)
        {
            totalLight += calculatePointLight(pointLights[i].color, pointLights[i].intensity, pointLights[i].attenuation, pointLights[i].position, pointLights[i].range, normal);
        }
    }
    
    for (int i = 0; i < MAX_SPOT_LIGHTS; i++)
    {
        if (spotLights[i].intensity > 0)
        {
            totalLight += calculateSpotLight(spotLights[i].color, spotLights[i].intensity, spotLights[i].attenuation, spotLights[i].position, spotLights[i].range, spotLights[i].direction, spotLights[i].cutoff, normal);
        }
    }
    
    fsout_fragColor = color * totalLight;
}