package com.netxforge.netxstudio.screens;

import org.eclipse.core.databinding.conversion.IConverter;


/**
 * Converts from Source to Target class. 
 * @author dzonekl
 *
 * @param <S>
 * @param <T>
 */
public  abstract class Converter<S, T> implements IConverter{
	public abstract Object convert(Object fromObject);
}