let express = require('express');
let router = express.Router();

router.post('/', function(req, res, next) {
  console.log(req.body);
  console.log(req.params);
  console.log(req.query);
  res.send('respond with a resource');
});


module.exports = router;
