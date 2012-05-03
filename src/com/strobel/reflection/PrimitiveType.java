package com.strobel.reflection;

import com.strobel.core.VerifyArgument;

import java.lang.annotation.Annotation;

/**
 * @author strobelm
 */
final class PrimitiveType extends Type {

    private final Class<?> _class;
    private final String _signature;
    private final String _description;

    PrimitiveType(final Class<?> clazz, final char signature, final String description) {
        _class = VerifyArgument.notNull(clazz, "clazz");
        
        if (!clazz.isPrimitive()) {
            throw Error.notPrimitiveType(clazz);
        }
        
        _signature = String.valueOf(signature);
        _description = VerifyArgument.notNull(description, "description");
    }

    @Override
    public boolean isPrimitive() {
        return true;
    }

    @Override
    public Class<?> getErasedClass() {
        return _class;
    }

    @Override
    public MemberCollection<? extends MemberInfo> getMember(final String name, final int bindingFlags, final MemberType... memberTypes) {
        return MemberCollection.empty();
    }

    @Override
    public FieldInfo getField(final String name, final int bindingFlags) {
        return null;
    }

    @Override
    public MethodInfo getMethod(final String name, final int bindingFlags, final CallingConvention callingConvention, final Type... parameterTypes) {
        return null;
    }

    @Override
    public ConstructorInfo getConstructor(final int bindingFlags, final CallingConvention callingConvention, final Type... parameterTypes) {
        return null;
    }

    @Override
    public MemberCollection<? extends MemberInfo> getMembers(final int bindingFlags) {
        return MemberCollection.empty();
    }

    @Override
    public FieldCollection getFields(final int bindingFlags) {
        return FieldCollection.empty();
    }

    @Override
    public MethodCollection getMethods(final int bindingFlags, final CallingConvention callingConvention) {
        return MethodCollection.empty();
    }

    @Override
    public ConstructorCollection getConstructors(final int bindingFlags) {
        return ConstructorCollection.empty();
    }

    @Override
    public TypeCollection getNestedTypes(final int bindingFlags) {
        return TypeCollection.empty();
    }

    @Override
    public MemberType getMemberType() {
        return MemberType.TypeInfo;
    }

    @Override
    public String getName() {
        return _class.getName();
    }

    @Override
    public Type getDeclaringType() {
        return null;
    }

    @Override
    int getModifiers() {
        return _class.getModifiers();
    }

    @Override
    public boolean isAnnotationPresent(final Class<? extends Annotation> annotationClass) {
        return _class.isAnnotationPresent(annotationClass);
    }

    @Override
    public <T extends Annotation> T getAnnotation(final Class<T> annotationClass) {
        return _class.getAnnotation(annotationClass);
    }

    @Override
    public Annotation[] getAnnotations() {
        return _class.getAnnotations();
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return _class.getDeclaredAnnotations();
    }

    @Override
    public StringBuilder appendSignature(final StringBuilder sb) {
        sb.append(_signature);
        return sb;
    }

    @Override
    public StringBuilder appendErasedSignature(final StringBuilder sb) {
        sb.append(_signature);
        return sb;
    }

    @Override
    public StringBuilder appendFullDescription(final StringBuilder sb) {
        sb.append(_description);
        return sb;
    }

    @Override
    public StringBuilder appendBriefDescription(final StringBuilder sb) {
        sb.append(_description);
        return sb;
    }
}