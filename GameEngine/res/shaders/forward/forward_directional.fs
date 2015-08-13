#version 330

in vec2 textureCoordinate0;
in vec3 normal0;
in vec3 worldPosition0;

out vec4 fragColor;

struct BaseLight
{
    vec3 color;
    float intensity;
};

struct DirectionalLight
{
    BaseLight baseLight;
    vec3 direction;
};

uniform vec3 eyePosition;

uniform sampler2D sampler;

uniform float specularIntensity;
uniform float specularExponent;

uniform DirectionalLight directionalLight;

vec4 calculateLight(BaseLight baseLight, vec3 direction, vec3 normal)
{
    float diffuseFactor = dot(normal, -direction);
    
    vec4 diffuseColor = vec4(0, 0, 0, 0);
    vec4 specularColor = vec4(0, 0, 0, 0);
    
    if (diffuseFactor > 0)
    {
        diffuseColor = vec4(baseLight.color, 1.0) * baseLight.intensity * diffuseFactor;
        
        vec3 directionToEye = normalize(eyePosition - worldPosition0);
        vec3 reflectDirection = normalize(reflect(direction, normal));
        
        float specularFactor = dot(directionToEye, reflectDirection);
        specularFactor = pow(specularFactor, specularExponent);
        
        if (specularFactor > 0)
        {
            specularColor = vec4(baseLight.color, 1.0) * specularIntensity * specularFactor;
        }
    }
    
    return diffuseColor + specularColor;
}

vec4 calculateDirectionalLight(DirectionalLight directionalLight, vec3 normal)
{
    return calculateLight(directionalLight.baseLight, -directionalLight.direction, normal);
}

void main()
{
    fragColor = texture(sampler, textureCoordinate0.xy) * calculateDirectionalLight(directionalLight, normalize(normal0));;
}