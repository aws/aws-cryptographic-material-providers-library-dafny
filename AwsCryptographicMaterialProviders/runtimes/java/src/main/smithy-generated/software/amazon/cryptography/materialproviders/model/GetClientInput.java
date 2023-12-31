// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.materialproviders.model;

import java.util.Objects;

/**
 * Inputs for getting a AWS KMS Client.
 */
public class GetClientInput {

  /**
   * The region the client should be created in.
   */
  private final String region;

  protected GetClientInput(BuilderImpl builder) {
    this.region = builder.region();
  }

  /**
   * @return The region the client should be created in.
   */
  public String region() {
    return this.region;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param region The region the client should be created in.
     */
    Builder region(String region);

    /**
     * @return The region the client should be created in.
     */
    String region();

    GetClientInput build();
  }

  static class BuilderImpl implements Builder {

    protected String region;

    protected BuilderImpl() {}

    protected BuilderImpl(GetClientInput model) {
      this.region = model.region();
    }

    public Builder region(String region) {
      this.region = region;
      return this;
    }

    public String region() {
      return this.region;
    }

    public GetClientInput build() {
      if (Objects.isNull(this.region())) {
        throw new IllegalArgumentException(
          "Missing value for required field `region`"
        );
      }
      return new GetClientInput(this);
    }
  }
}
