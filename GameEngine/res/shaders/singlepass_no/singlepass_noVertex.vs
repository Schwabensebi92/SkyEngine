#version 330

layout(location = 0) in vec3 position;
layout(location = 1) in vec2 textureCoordinate;
layout(location = 2) in vec3 normal;

out vec2 vsout_textureCoordinate;
out vec3 vsout_normal;
out vec3 vsout_worldPosition;

uniform mat4 transform;
uniform mat4 transformProjected;

void main()
{
    gl_Position = transformProjected * vec4(position, 1.0);
    vsout_textureCoordinate = textureCoordinate;
    vsout_normal = (transform * vec4(normal, 0.0)).xyz;
    vsout_worldPosition = (transform * vec4(position, 1.0)).xyz;
}