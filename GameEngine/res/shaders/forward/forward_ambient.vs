#version 330

layout(location = 0) in vec3 position;
layout(location = 1) in vec2 textureCoordinate;

out vec2 textureCoordinate0;

uniform mat4 transformProjected;

void main()
{
    gl_Position = transformProjected * vec4(position, 1.0);
    textureCoordinate0 = textureCoordinate;
}