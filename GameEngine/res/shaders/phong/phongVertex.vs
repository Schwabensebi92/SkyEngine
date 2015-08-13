#version 330

layout(location = 0) in vec3 position;
layout(location = 1) in vec2 textureCoordinate;
layout(location = 2) in vec3 normal;

out vec2 textureCoordinate0;
out vec3 normal0;
out vec3 worldPosition0;

uniform mat4 transform;
uniform mat4 transformProjected;

void main()
{
    gl_Position = transformProjected * vec4(position, 1.0);
    textureCoordinate0 = textureCoordinate;
    normal0 = (transform * vec4(normal, 0.0)).xyz;
    worldPosition0 = (transform * vec4(position, 1.0)).xyz;
}