package ptm.home.converter.hibernate;

import ptm.home.common.constant.Gender;

import javax.persistence.AttributeConverter;

public class GenderAttributeConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender attribute) {
		if (attribute == null) {
			throw new IllegalArgumentException("source cannot be null");
		}
		return attribute.toString();
	}

	@Override
	public Gender convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			throw new IllegalArgumentException("source cannot be null");
		}
		Gender g = Gender.valueOf(dbData.toUpperCase());
		return g;
	}
}
