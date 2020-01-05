//package com.hemalatha.pandora.dataloader;
//
//import org.apache.commons.lang3.StringUtils;
//import org.hibernate.boot.model.naming.Identifier;
//import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
//import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
//
//import java.util.LinkedList;
//
//public class SegmentedNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {
//
//	@Override
//	public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
//		LinkedList<String> parts = new LinkedList<>();
//		String columnName = transformAttributePath(source.getAttributePath());
//
//		for (String word : StringUtils.splitByCharacterTypeCamelCase(columnName)) {
//			if (word != null && !"_".equals(word) && !word.trim().isEmpty()) {
//				parts.add(word.toLowerCase());
//			}
//		}
//		String newId = StringUtils.join(parts.toArray(), "_");
//		return Identifier.toIdentifier(newId);
//	}
//
//}