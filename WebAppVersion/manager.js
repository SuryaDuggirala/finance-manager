const express = require('express');
const logger = require('morgan');
const bodyParser = require('body-parser');

// SET UP THE EXPRESS APP
const manager = express();

manager.use(logger('dev'));

//PARSE INCOMING REQUESTS DATA (HTTPS://GITHUB.COM/EXPRESSJS/BODY-PARSER
manager.use(bodyParser.json());
manager.use(bodyParser.urlencoded({extended: false}));

// SETUP A DEFAULT CATCH-ALL ROUTE THAT SENDS BACK A WELCOME MESSAGE IN JSON FORMAT
manager.get('*', (req, res) => res.status(200).send({
    message: 'Welcome to your new financial manager!',
}));

module.exports = manager;



