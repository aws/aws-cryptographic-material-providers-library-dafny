// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.primitives.model;

public enum HKDFPolicy {
  REQUIRE_FIPS_HKDF("REQUIRE_FIPS_HKDF"),

  NONE("NONE");

  private final String value;

  private HKDFPolicy(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
