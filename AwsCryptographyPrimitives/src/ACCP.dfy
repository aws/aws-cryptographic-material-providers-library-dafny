// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyPrimitivesTypes.dfy"
include "Digest.dfy"

module
  {:options "-functionSyntax:4"}
{:extern "ACCP"}
ACCP
{
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import Types = AwsCryptographyPrimitivesTypes
  import Digest
    // An extern that checks for ACCP
    // if hdfkPolicy is NONE,  return if ACCP is installed and version is >= 2.3
    // otherwise, return if ACCP is installed, version is >= 2.3, && FIPS is enabled.
  method
    {:extern "ACCP.ACCPUtils", "ExternCheckForAccp"}
  ExternCheckForAccp()
    returns (output: Result<Types.HKDFProvider, Types.Error>)

  method Extract(input: Types.HkdfExtractInput)
    returns (output: Result<seq<uint8>, Types.Error>)
  {
    :- Need(
      && (input.salt.None? || |input.salt.value| != 0)
      && |input.ikm| < INT32_MAX_LIMIT,
      Types.AwsCryptographicPrimitivesError(message := "HKDF Extract needs a salt and reasonable ikm.")
    );
    output := ExternExtract(input);
  }

  method
    {:extern "ACCP.ACCP_HKDF", "ExternExtract"}
  ExternExtract(input: Types.HkdfExtractInput)
    returns (output: Result<seq<uint8>, Types.Error>)

  method Expand(input: Types.HkdfExpandInput)
    returns (output: Result<seq<uint8>, Types.Error>)
    ensures output.Success? ==> |output.value| == input.expectedLength as nat
  {

    :- Need(
      && 1 <= input.expectedLength as int <= 255 * Digest.Length(input.digestAlgorithm)
      && |input.info| < INT32_MAX_LIMIT
      && Digest.Length(input.digestAlgorithm) == |input.prk|,
      Types.AwsCryptographicPrimitivesError(message := "HKDF Expand needs valid input.")
    );

    output := ExternExpand(input);
  }

  method
    {:extern "ACCP.ACCP_HKDF", "ExternExpand"}
  ExternExpand(input: Types.HkdfExpandInput)
    returns (output: Result<seq<uint8>, Types.Error>)
    ensures output.Success? ==> |output.value| == input.expectedLength as nat

  method Hkdf(input: Types.HkdfInput)
    returns (output: Result<seq<uint8>, Types.Error>)
    ensures output.Success? ==> |output.value| == input.expectedLength as nat
  {

    :- Need(
      && 1 <= input.expectedLength as int <= 255 * Digest.Length(input.digestAlgorithm)
      && (input.salt.None? || |input.salt.value| != 0)
      && |input.info| < INT32_MAX_LIMIT
      && |input.ikm| < INT32_MAX_LIMIT,
      Types.AwsCryptographicPrimitivesError(message := "Wrapped Hkdf input is invalid.")
    );
    output := ExternHkdf(input);
  }

  method
    {:extern "ACCP.ACCP_HKDF", "ExternHkdf"}
  ExternHkdf(input: Types.HkdfInput)
    returns (output: Result<seq<uint8>, Types.Error>)
    ensures output.Success? ==> |output.value| == input.expectedLength as nat

}
