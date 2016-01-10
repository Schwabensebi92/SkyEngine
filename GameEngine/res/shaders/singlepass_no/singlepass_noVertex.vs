#version 330

// https://www.opengl.org/wiki/Built-in_Variable_(GLSL)

layout(location = 0) in vec3 position;
layout(location = 1) in vec2 textureCoordinate;
layout(location = 2) in vec3 normal;

out vec2 vsout_textureCoordinate;
out vec3 vsout_normal;
out vec3 vsout_worldPosition;

uniform mat4 worldMatrix;
uniform mat4 worldViewProjectionMatrix;

void main()
{
    gl_Position = worldViewProjectionMatrix * vec4(position, 1.0);
    vsout_textureCoordinate = textureCoordinate;
    vsout_normal = (worldMatrix * vec4(normal, 0.0)).xyz;
    vsout_worldPosition = (worldMatrix * vec4(position, 1.0)).xyz;
}