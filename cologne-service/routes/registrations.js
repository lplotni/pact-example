let express = require('express');
let router = express.Router();

router.get('/', function (req, res, next) {
  res.send(
    {
      city: "Cologne",
      gasoline: {2017: 110},
      diesel: {2017: 20}
    }
  );
});

module.exports = router;
