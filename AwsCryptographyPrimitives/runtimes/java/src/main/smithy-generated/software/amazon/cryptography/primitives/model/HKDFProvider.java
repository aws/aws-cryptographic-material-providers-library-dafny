// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.primitives.model;

public enum HKDFProvider {
  ACCP("ACCP"),

  MPL("MPL");

  private final String value;

  private HKDFProvider(String value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }
}
