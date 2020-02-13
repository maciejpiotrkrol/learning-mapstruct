package com.learning.mapstruct.basics;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring")
public interface PackageTypeMapper {

  @ValueMappings({
          @ValueMapping(source = "DEFAULT", target = "STANDARD"),
          @ValueMapping(source = "PREMIUM", target = "PREMIUM")
  })
  InternalPackageType externalPackageTypeToInternalPackageType(ExternalPackageType externalPackageType);


  @ValueMappings({
          @ValueMapping(source = "STANDARD", target = "DEFAULT"),
          @ValueMapping(source = "PREMIUM", target = "PREMIUM"),
          @ValueMapping(source = "EXTRA_PREMIUM", target = "PREMIUM")
  })
  ExternalPackageType internalPackageTypeToExternalPackageType(InternalPackageType internalPackageType);
}
