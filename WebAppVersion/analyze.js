'use strict';

const fileParse = require('./fileParse.js');


let parser = new fileParse('./expenses.txt');
let db = new sqlize("Expenses");







