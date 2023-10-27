// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be
// overwritten.
package software.amazon.cryptography.primitives.model;

import java.nio.ByteBuffer;
import java.util.Objects;

public class DigestOutput {

  private final ByteBuffer digest;

  protected DigestOutput(BuilderImpl builder) {
    this.digest = builder.digest();
  }

  public ByteBuffer digest() {
    return this.digest;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder digest(ByteBuffer digest);

    ByteBuffer digest();

    DigestOutput build();
  }

  static class BuilderImpl implements Builder {

    protected ByteBuffer digest;

    protected BuilderImpl() {}

    protected BuilderImpl(DigestOutput model) {
      this.digest = model.digest();
    }

    public Builder digest(ByteBuffer digest) {
      this.digest = digest;
      return this;
    }

    public ByteBuffer digest() {
      return this.digest;
    }

    public DigestOutput build() {
      if (Objects.isNull(this.digest())) {
        throw new IllegalArgumentException(
          "Missing value for required field `digest`"
        );
      }
      return new DigestOutput(this);
    }
  }
}
