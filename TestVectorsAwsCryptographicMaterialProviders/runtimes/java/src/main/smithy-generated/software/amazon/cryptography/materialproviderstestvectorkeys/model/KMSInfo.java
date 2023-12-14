// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.materialproviderstestvectorkeys.model;

import java.util.Objects;

public class KMSInfo {
  private final String keyId;

  protected KMSInfo(BuilderImpl builder) {
    this.keyId = builder.keyId();
  }

  public String keyId() {
    return this.keyId;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder keyId(String keyId);

    String keyId();

    KMSInfo build();
  }

  static class BuilderImpl implements Builder {
    protected String keyId;

    protected BuilderImpl() {
    }

    protected BuilderImpl(KMSInfo model) {
      this.keyId = model.keyId();
    }

    public Builder keyId(String keyId) {
      this.keyId = keyId;
      return this;
    }

    public String keyId() {
      return this.keyId;
    }

    public KMSInfo build() {
      if (Objects.isNull(this.keyId()))  {
        throw new IllegalArgumentException("Missing value for required field `keyId`");
      }
      return new KMSInfo(this);
    }
  }
}
