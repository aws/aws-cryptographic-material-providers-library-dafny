// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be
// overwritten.
package software.amazon.cryptography.materialproviders.model;

import java.util.List;
import software.amazon.cryptography.materialproviders.ClientSupplier;
import software.amazon.cryptography.materialproviders.IClientSupplier;

/** Inputs for for creating a AWS KMS MRK Multi-Keyring. */
public class CreateAwsKmsMrkMultiKeyringInput {

  /**
   * A symmetric AWS KMS Key or AWS KMS Multi-Region Key responsible for wrapping and unwrapping
   * data keys. KMS.GenerateDataKey may be called with this key if the data key has not already been
   * generated by another Keyring.
   */
  private final String generator;

  /**
   * A list of identifiers for the symmetric AWS KMS Keys and/or AWS KMS Multi-Region Keys (other
   * than the generator) responsible for wrapping and unwrapping data keys.
   */
  private final List<String> kmsKeyIds;

  /**
   * The Client Supplier which will be used to get KMS Clients for use with this Keyring. The Client
   * Supplier will create a client for each region specified in the generator and kmsKeyIds ARNs. If
   * not specified on input, the Default Client Supplier is used.
   */
  private final IClientSupplier clientSupplier;

  /** A list of grant tokens to be used when calling KMS. */
  private final List<String> grantTokens;

  protected CreateAwsKmsMrkMultiKeyringInput(BuilderImpl builder) {
    this.generator = builder.generator();
    this.kmsKeyIds = builder.kmsKeyIds();
    this.clientSupplier = builder.clientSupplier();
    this.grantTokens = builder.grantTokens();
  }

  /**
   * @return A symmetric AWS KMS Key or AWS KMS Multi-Region Key responsible for wrapping and
   *     unwrapping data keys. KMS.GenerateDataKey may be called with this key if the data key has
   *     not already been generated by another Keyring.
   */
  public String generator() {
    return this.generator;
  }

  /**
   * @return A list of identifiers for the symmetric AWS KMS Keys and/or AWS KMS Multi-Region Keys
   *     (other than the generator) responsible for wrapping and unwrapping data keys.
   */
  public List<String> kmsKeyIds() {
    return this.kmsKeyIds;
  }

  /**
   * @return The Client Supplier which will be used to get KMS Clients for use with this Keyring.
   *     The Client Supplier will create a client for each region specified in the generator and
   *     kmsKeyIds ARNs. If not specified on input, the Default Client Supplier is used.
   */
  public IClientSupplier clientSupplier() {
    return this.clientSupplier;
  }

  /**
   * @return A list of grant tokens to be used when calling KMS.
   */
  public List<String> grantTokens() {
    return this.grantTokens;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param generator A symmetric AWS KMS Key or AWS KMS Multi-Region Key responsible for wrapping
     *     and unwrapping data keys. KMS.GenerateDataKey may be called with this key if the data key
     *     has not already been generated by another Keyring.
     */
    Builder generator(String generator);

    /**
     * @return A symmetric AWS KMS Key or AWS KMS Multi-Region Key responsible for wrapping and
     *     unwrapping data keys. KMS.GenerateDataKey may be called with this key if the data key has
     *     not already been generated by another Keyring.
     */
    String generator();

    /**
     * @param kmsKeyIds A list of identifiers for the symmetric AWS KMS Keys and/or AWS KMS
     *     Multi-Region Keys (other than the generator) responsible for wrapping and unwrapping data
     *     keys.
     */
    Builder kmsKeyIds(List<String> kmsKeyIds);

    /**
     * @return A list of identifiers for the symmetric AWS KMS Keys and/or AWS KMS Multi-Region Keys
     *     (other than the generator) responsible for wrapping and unwrapping data keys.
     */
    List<String> kmsKeyIds();

    /**
     * @param clientSupplier The Client Supplier which will be used to get KMS Clients for use with
     *     this Keyring. The Client Supplier will create a client for each region specified in the
     *     generator and kmsKeyIds ARNs. If not specified on input, the Default Client Supplier is
     *     used.
     */
    Builder clientSupplier(IClientSupplier clientSupplier);

    /**
     * @return The Client Supplier which will be used to get KMS Clients for use with this Keyring.
     *     The Client Supplier will create a client for each region specified in the generator and
     *     kmsKeyIds ARNs. If not specified on input, the Default Client Supplier is used.
     */
    IClientSupplier clientSupplier();

    /**
     * @param grantTokens A list of grant tokens to be used when calling KMS.
     */
    Builder grantTokens(List<String> grantTokens);

    /**
     * @return A list of grant tokens to be used when calling KMS.
     */
    List<String> grantTokens();

    CreateAwsKmsMrkMultiKeyringInput build();
  }

  static class BuilderImpl implements Builder {

    protected String generator;

    protected List<String> kmsKeyIds;

    protected IClientSupplier clientSupplier;

    protected List<String> grantTokens;

    protected BuilderImpl() {}

    protected BuilderImpl(CreateAwsKmsMrkMultiKeyringInput model) {
      this.generator = model.generator();
      this.kmsKeyIds = model.kmsKeyIds();
      this.clientSupplier = model.clientSupplier();
      this.grantTokens = model.grantTokens();
    }

    public Builder generator(String generator) {
      this.generator = generator;
      return this;
    }

    public String generator() {
      return this.generator;
    }

    public Builder kmsKeyIds(List<String> kmsKeyIds) {
      this.kmsKeyIds = kmsKeyIds;
      return this;
    }

    public List<String> kmsKeyIds() {
      return this.kmsKeyIds;
    }

    public Builder clientSupplier(IClientSupplier clientSupplier) {
      this.clientSupplier = ClientSupplier.wrap(clientSupplier);
      return this;
    }

    public IClientSupplier clientSupplier() {
      return this.clientSupplier;
    }

    public Builder grantTokens(List<String> grantTokens) {
      this.grantTokens = grantTokens;
      return this;
    }

    public List<String> grantTokens() {
      return this.grantTokens;
    }

    public CreateAwsKmsMrkMultiKeyringInput build() {
      return new CreateAwsKmsMrkMultiKeyringInput(this);
    }
  }
}
