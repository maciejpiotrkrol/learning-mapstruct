package com.learning.mapstruct.basics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PackageTypeMapperTest {

  @Autowired
  PackageTypeMapper packageTypeMapper;

  @Test
  void externalPackageTypeToInternalPackageType() {
    ExternalPackageType aDefault = ExternalPackageType.DEFAULT;
    ExternalPackageType externalPremium = ExternalPackageType.PREMIUM;

    InternalPackageType standard = packageTypeMapper.externalPackageTypeToInternalPackageType(aDefault);
    InternalPackageType premium = packageTypeMapper.externalPackageTypeToInternalPackageType(externalPremium);

    assertEquals(InternalPackageType.STANDARD, standard);
    assertEquals(InternalPackageType.PREMIUM, premium);
  }

  @Test
  void internalPackageTypeToExternalPackageType() {
    InternalPackageType standard = InternalPackageType.STANDARD;
    InternalPackageType premium = InternalPackageType.PREMIUM;
    InternalPackageType extraPremium = InternalPackageType.EXTRA_PREMIUM;

    ExternalPackageType aDefault = packageTypeMapper.internalPackageTypeToExternalPackageType(standard);
    ExternalPackageType externalPremium = packageTypeMapper.internalPackageTypeToExternalPackageType(premium);
    ExternalPackageType externalExtraPremium = packageTypeMapper.internalPackageTypeToExternalPackageType(extraPremium);

    assertEquals(ExternalPackageType.DEFAULT, aDefault);
    assertEquals(ExternalPackageType.PREMIUM, externalPremium);
    assertEquals(ExternalPackageType.PREMIUM, externalExtraPremium);

  }
}