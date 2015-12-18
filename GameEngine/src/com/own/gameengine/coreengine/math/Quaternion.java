package com.own.gameengine.coreengine.math;


/**
 * Represents a 4-component Quaternion of the form: Q = w + <i>i</i>x + <i>j</i>y + <i>k</i>z
 * 
 * @author Sebastian Utz
 * @see <a href="http://www.euclideanspace.com/maths/algebra/realNormedAlgebra/quaternions/index.htm">euclideanspace.com/quaternions/</a>
 * @see <a href=
 *      "http://www.geeks3d.com/20141201/how-to-rotate-a-vertex-by-a-quaternion-in-glsl/">geeks3d.com/how-to-rotate-a-vertex-by-a-quaternion
 *      -in-glsl/</a>
 */
public class Quaternion {
	
	//@formatter:off
	/*
	 * w []
	 * x []
	 * y []
	 * z []
	 */
	//@formatter:on
	
	/**
	 * Real part of the Quaternion.
	 */
	private float	w;
	/**
	 * Imaginary part x of the Quaternion.
	 */
	private float	x;
	/**
	 * Imaginary part y of the Quaternion.
	 */
	private float	y;
	/**
	 * Imaginary part z of the Quaternion.
	 */
	private float	z;
	
	/**
	 * Private constructor for a Quaternion with the values <code>w</code>, <code>x</code>, <code>y</code> and <code>z</code>.
	 * 
	 * @param w
	 *            Real part of the Quaternion.
	 * @param x
	 *            Imaginary part x of the Quaternion.
	 * @param y
	 *            Imaginary part y of the Quaternion.
	 * @param z
	 *            Imaginary part z of the Quaternion.
	 */
	private Quaternion(final float w, final float x, final float y, final float z) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Constructor of a rotation.<br>
	 * <br>
	 * <b>E.g.:</b><br>
	 * <ul>
	 * Rotation of PI/2 around y-axis(0.0, 1.0, 0.0).
	 * </ul>
	 * <br>
	 * <i>Before rotation:</i> Forward(0.0, 0.0, 1.0), Up(0.0, 1.0, 0.0), Right(1.0, 0.0, 0.0)<br>
	 * <i>After rotation:</i> Forward(-1.0, 0.0, 0.0), Up(0.0, 1.0, 0.0), Right(0.0, 0.0, 1.0)
	 * 
	 * @param axis
	 *            The axis around which the rotation is defined.
	 * @param angle
	 *            Angle of rotation around <code>axis</code>.
	 */
	public Quaternion(final Vector3f axis, final float angle) {
		float sinHalfAngle = (float) Math.sin(angle / 2.0f);
		float cosHalfAngle = (float) Math.cos(angle / 2.0f);
		
		x = axis.getX() * sinHalfAngle;
		y = axis.getY() * sinHalfAngle;
		z = axis.getZ() * sinHalfAngle;
		w = cosHalfAngle;
	}
	
	/**
	 * Copy constructor for a Quaternion.
	 * 
	 * @param source
	 *            The Quaternion, which is copied to this Quaternion.
	 */
	public Quaternion(final Quaternion source) {
		this(source.w, source.x, source.y, source.z);
	}
	
	/**
	 * Calculates the length of this Quaternion.
	 * 
	 * @return Returns the length of this Quaternion.
	 */
	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	/**
	 * Normalizes this Quaternion to length <code>1</code>.
	 * 
	 * @return Returns this Quaternion.
	 */
	public Quaternion normalize() {
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}
	
	/**
	 * Builds the Conjugate of this Quaternion.
	 * 
	 * @return Returns this Quaternion.
	 */
	public Quaternion conjugate() {
		x *= -1;
		y *= -1;
		z *= -1;
		
		return this;
	}
	
	/**
	 * Multiplies this Quaternion with Quaternion <code>other</code> in the following order:<br>
	 * <code>this'</code> = <code>this</<code> * <code>other</code>
	 * 
	 * @param other
	 *            The Quaternion, with which this Quaternion is multiplied.
	 * @see <a href=
	 *      "http://www.euclideanspace.com/maths/algebra/realNormedAlgebra/quaternions/arithmetic/">euclideanspace.com/quaternions/
	 *      arithmetic</a>
	 * @return Returns this Quaternion.
	 */
	public Quaternion mul(final Quaternion other) {
		float newW = w * other.w - x * other.x - y * other.y - z * other.z;
		float newX = x * other.w + w * other.x + y * other.z - z * other.y;
		float newY = w * other.y - x * other.z + y * other.w + z * other.x;
		float newZ = w * other.z + x * other.y - y * other.x + z * other.w;
		
		w = newW;
		x = newX;
		y = newY;
		z = newZ;
		
		return this;
	}
	
	/**
	 * Multiplies this Quaternion with Vector3f <code>vector</code> in the following order:<br>
	 * <code>this'</code> = <code>this</<code> * <code>vector</code>
	 * 
	 * @param vector
	 *            The Vector3f, with which this Quaternion is multiplied.
	 * @see <a href=
	 *      "http://www.euclideanspace.com/maths/algebra/realNormedAlgebra/quaternions/transforms/index.htm">euclideanspace.com/quaternions/
	 *      transforms</a>
	 * @return Returns this Quaternion.
	 */
	protected Quaternion mul(final Vector3f vector) {
		return mul(new Quaternion(0.0f, vector.getX(), vector.getY(), vector.getZ()));
	}
	
	/**
	 * Calculates the forward vector of the rotation represented by this Quaternion in the <code>CoordinateSystem</code>.
	 * 
	 * @return Returns the forward direction.
	 */
	public Vector3f getForwardVector() {
		return new Vector3f(CoordinateSystem.Z_AXIS).rotate(new Quaternion(this));
	}
	
	/**
	 * Calculates the back vector of the rotation represented by this Quaternion in the <code>CoordinateSystem</code>.
	 * 
	 * @return Returns the back direction.
	 */
	public Vector3f getBackVector() {
		return getForwardVector().mul(-1.0f);
	}
	
	/**
	 * Calculates the up vector of the rotation represented by this Quaternion in the <code>CoordinateSystem</code>.
	 * 
	 * @return Returns the up direction.
	 */
	public Vector3f getUpVector() {
		return new Vector3f(CoordinateSystem.Y_AXIS).rotate(new Quaternion(this));
	}
	
	/**
	 * Calculates the down vector of the rotation represented by this Quaternion in the <code>CoordinateSystem</code>.
	 * 
	 * @return Returns the down direction.
	 */
	public Vector3f getDownVector() {
		return getUpVector().mul(-1.0f);
	}
	
	/**
	 * Calculates the right vector of the rotation represented by this Quaternion in the <code>CoordinateSystem</code>.
	 * 
	 * @return Returns the right direction.
	 */
	public Vector3f getRightVector() {
		return new Vector3f(CoordinateSystem.X_AXIS).rotate(new Quaternion(this));
	}
	
	/**
	 * Calculates the left vector of the rotation represented by this Quaternion in the <code>CoordinateSystem</code>.
	 * 
	 * @return Returns the left direction.
	 */
	public Vector3f getLeftVector() {
		return getRightVector().mul(-1.0f);
	}
	
	/**
	 * Returns the real part of this Quaternion.
	 * 
	 * @return Returns the real part of this Quaternion.
	 */
	public float getW() {
		return w;
	}
	
	/**
	 * Sets the real part of this Quaternion.
	 * 
	 * @param w
	 *            Sets the real part of this Quaternion.
	 */
	private void setW(final float w) {
		this.w = w;
	}
	
	/**
	 * Returns the imaginary part x of this Quaternion.
	 * 
	 * @return Returns the imaginary part x of this Quaternion.
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Sets the imaginary part x of this Quaternion.
	 * 
	 * @param x
	 *            Sets the imaginary part x of this Quaternion.
	 */
	private void setX(final float x) {
		this.x = x;
	}
	
	/**
	 * Returns the imaginary part y of this Quaternion.
	 * 
	 * @return Returns the imaginary part y of this Quaternion.
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets the imaginary part y of this Quaternion.
	 * 
	 * @param y
	 *            Sets the imaginary part y of this Quaternion.
	 */
	private void setY(final float y) {
		this.y = y;
	}
	
	/**
	 * Returns the imaginary part z of this Quaternion.
	 * 
	 * @return Returns the imaginary part z of this Quaternion.
	 */
	public float getZ() {
		return z;
	}
	
	/**
	 * Sets the imaginary part z of this Quaternion.
	 * 
	 * @param z
	 *            Sets the imaginary part z of this Quaternion.
	 */
	private void setZ(final float z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "(" + x + "/" + y + "/" + z + "/" + w + ")";
	}
	
	@Override
	public boolean equals(final Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Quaternion))
			return false;
		Quaternion otherQuaternion = (Quaternion) other;
		return (x == otherQuaternion.x) && (y == otherQuaternion.y) && (z == otherQuaternion.z) && (w == otherQuaternion.w);
	}
	
	@Override
	public int hashCode() {
		return (int) (x * 7 + y * 11 + z * 13 + w * 17);
	}
}
