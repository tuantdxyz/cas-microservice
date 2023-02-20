package com.cas.library.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

public class ModelMapperUtils {

	private static final String DATE_INPUT_FORMAT = "dd/MM/yyyy HH:mm:ss";
	private static final String DATE_OUTPUT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static ModelMapper modelMapper;

	private ModelMapperUtils() {
	}

	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

		// Converter map String to LocalDateTime
		Converter<String, LocalDateTime> localDateTimeConverter = new Converter<String, LocalDateTime>() {
			@Override
			public LocalDateTime convert(MappingContext<String, LocalDateTime> context) {
				String source = context.getSource();
				if (StringUtils.isBlank(source)) {
					return null;
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_INPUT_FORMAT);
				LocalDate localDate = LocalDate.parse(source, formatter);
				return localDate.atStartOfDay();
			}
		};
		modelMapper.addConverter(localDateTimeConverter);

		// Converter map LocalDateTime to String
		Converter<LocalDateTime, String> localDateTimeToStringConverter = new Converter<LocalDateTime, String>() {
			@Override
			public String convert(MappingContext<LocalDateTime, String> context) {
				LocalDateTime source = context.getSource();
				if (source == null) {
					return null;
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_OUTPUT_FORMAT);
				return source.format(formatter);
			}
		};
		modelMapper.addConverter(localDateTimeToStringConverter);
	}

	/**
	 * Map an object to a new object with the same property name, otherwise the
	 * attribute value will be null
	 * <p>
	 * <b>Note:</b> outClassObject object must have default constructor with no
	 * arguments
	 * </p>
	 * 
	 * @param <S>            type of source object
	 * @param <D>            type of result object
	 * @param sourceObject   object that needs to be mapped
	 * @param outClassObject class of result object
	 * @return new object of <code>outClassObject</code> type
	 */
	public static <S, D> D map(S sourceObject, Class<D> outClassObject) {
		return modelMapper.map(sourceObject, outClassObject);
	}

	/**
	 * Merge object to object with the same property name and properties in
	 * sourceObject is not null
	 * 
	 * @param <S>          type of source object
	 * @param <D>          type of result object
	 * @param sourceObject object that needs to be merged
	 * @param outObject    result object
	 * @return <code>outObject</code> with value merged with sourceObject
	 */
	public static <S, D> void merge(S sourceObject, D outObject) {
		modelMapper.map(sourceObject, outObject);
	}

	/**
	 * Map an collection object to a new collection object with the same property
	 * name, otherwise the attribute value will be null
	 * 
	 * <p>
	 * <b>Note:</b> outClassObject object must have default constructor with no
	 * arguments
	 * </p>
	 * 
	 * @param <S>              type of source object in sourceCollection
	 * @param <D>              type of result object
	 * @param sourceCollection collection of source object that needs to be mapped
	 * @param outClassObject   class of result object
	 * @return list of mapped object with <code>D</code> type
	 */
	public static <S, D> List<D> mapAll(Collection<S> sourceCollection, Class<D> outClassObject) {
		return sourceCollection.stream().map(sourceObject -> map(sourceObject, outClassObject))
				.collect(Collectors.toList());
	}

}
