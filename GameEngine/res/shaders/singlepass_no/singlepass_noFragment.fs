#version 330

in vec2 vsout_textureCoordinate;

out vec4 fsout_fragColor;

uniform vec3 baseColor;
uniform sampler2D sampler;
uniform int useTexture;

void main()
{
    vec4 color = vec4(baseColor, 1);

    vec4 textureColor = texture(sampler, vsout_textureCoordinate.xy);
    
    if (useTexture == 1)
        color *= textureColor;
    
    fsout_fragColor = color;
}