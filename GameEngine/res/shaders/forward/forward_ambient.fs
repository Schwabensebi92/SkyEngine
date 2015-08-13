#version 330

in vec2 textureCoordinate0;

uniform vec3 ambientIntensity;
uniform sampler2D sampler;

out vec4 fragColor;

void main()
{
    fragColor = texture(sampler, textureCoordinate0.xy) * vec4(ambientIntensity, 1);
}