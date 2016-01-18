package com.own.gameengine.renderingengine.concept.shader.uniform;


/**
 * Supported uniform types.
 * 
 * @author Sebastian Utz
 * 		
 */
public enum UniformType {
	
	Integer(java.lang.Integer.class),
	Float(java.lang.Float.class),
	Vector2f(com.own.gameengine.coreengine.math.Vector2f.class),
	Vector3f(com.own.gameengine.coreengine.math.Vector3f.class),
	Matrix4f(com.own.gameengine.coreengine.math.matrix.Matrix4f.class),
	Texture(com.own.gameengine.renderingengine.graphics.object.Texture.class);
	
	private Class<?> type;
	
	private UniformType(Class<?> type) {
		this.type = type;
	}
	
	public Class<?> getType() {
		return type;
	}
}
