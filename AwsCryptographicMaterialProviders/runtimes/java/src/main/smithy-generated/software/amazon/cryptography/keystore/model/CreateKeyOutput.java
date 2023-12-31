// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.keystore.model;

import java.util.Objects;

/**
 * Outputs for Branch Key creation.
 */
public class CreateKeyOutput {

  /**
   * A identifier for the created Branch Key.
   */
  private final String branchKeyIdentifier;

  protected CreateKeyOutput(BuilderImpl builder) {
    this.branchKeyIdentifier = builder.branchKeyIdentifier();
  }

  /**
   * @return A identifier for the created Branch Key.
   */
  public String branchKeyIdentifier() {
    return this.branchKeyIdentifier;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param branchKeyIdentifier A identifier for the created Branch Key.
     */
    Builder branchKeyIdentifier(String branchKeyIdentifier);

    /**
     * @return A identifier for the created Branch Key.
     */
    String branchKeyIdentifier();

    CreateKeyOutput build();
  }

  static class BuilderImpl implements Builder {

    protected String branchKeyIdentifier;

    protected BuilderImpl() {}

    protected BuilderImpl(CreateKeyOutput model) {
      this.branchKeyIdentifier = model.branchKeyIdentifier();
    }

    public Builder branchKeyIdentifier(String branchKeyIdentifier) {
      this.branchKeyIdentifier = branchKeyIdentifier;
      return this;
    }

    public String branchKeyIdentifier() {
      return this.branchKeyIdentifier;
    }

    public CreateKeyOutput build() {
      if (Objects.isNull(this.branchKeyIdentifier())) {
        throw new IllegalArgumentException(
          "Missing value for required field `branchKeyIdentifier`"
        );
      }
      return new CreateKeyOutput(this);
    }
  }
}
