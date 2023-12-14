// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyPrimitivesTypes.dfy"
include "AwsCryptographyPrimitivesOperations.dfy"

module {:extern "software.amazon.cryptography.primitives.internaldafny" } Aws.Cryptography.Primitives refines AbstractAwsCryptographyPrimitivesService {
  import Operations = AwsCryptographyPrimitivesOperations

  function method DefaultCryptoConfig(): CryptoConfig {
    CryptoConfig()
  }

  method AtomicPrimitives(config: CryptoConfig)
    returns (res: Result<AtomicPrimitivesClient, Error>)
  {
    var finalConfig: Operations.Config;
    var accpInstalled :- CheckForAccp();
    finalConfig := Operations.Config(
      hkdfProvider := accpInstalled
    );
    var client := new AtomicPrimitivesClient(finalConfig);
    return Success(client);
  }

  method CheckForAccp()
    returns (res: Result<HKDFProvider, Error>)
  {
    res := Operations.CheckForAccp();
  }

  class AtomicPrimitivesClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IAwsCryptographicPrimitivesClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }
}
