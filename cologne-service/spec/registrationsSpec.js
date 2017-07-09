describe("cologne-service", () => {
  const verifier = require("pact").Verifier;

  it("should fullfill all contracts", (done) => {
    let opts = {
      providerBaseUrl: "http://localhost:3000",
      pactBrokerUrl: "http://localhost",
      provider: "cologne-service",
      providerStatesSetupUrl: "http://localhost:3000/cdc-setup/",
    };

    verifier.verifyProvider(opts)
      .then(done)
      .catch(done.fail);
  });

});