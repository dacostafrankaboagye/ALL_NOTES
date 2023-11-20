
    console.log(typeof(8));


    const theCheck = require("./tryOne");

    theCheck();





    // npm

    npm init

    npm install validator


    const validator = require("validator");

    console.log(validator.isURL("https://ashesi.edu.gh"))  // true



    // command - line 
    process.argv




    const command = process.argv[2] ; 

    if (command === 'add'){
        console.log("Added the file");

    }else if (command === 'remove'){
        console.log("remove the file")
    }


    // bare-bones way to access command line arguments

    Yargs to easily set up a more complex set of arguments for 
    your application.


    npm install yars





    const yargs = require('yargs');

    yargs.version('1.1.0');

    yargs.command({
        command: "add",
        describe: "Add a new note",
        handler: function(){
            console.log("Now notes have been added!");
        }
    })


    console.log(yargs.argv)  // app.js --help   node.js --version

    // builder property - set options for commandline 





    const yargs = require('yargs');

    yargs.command({
        command: "add",
        description: "Adding something",
        builder: {
            title:{
                describe: "Note title",
                demandOption: true,
                type: 'string'
            },
            body: {
                describe: "Note for the body",
                demandOption: true,
                type: 'string'
            }
        },
        handler: function(argv){
            console.log(`The title is ${argv.title}`);
            console.log(`The body is ${argv.body}`);
        }
    })


    yargs.argv

    // node app.js add --title="the title" --body="the body"





    // JSON

    - two methods for working with JSON

    JSON string -> JSON object = JSON.parse 
    JSON object -> JSON string = JSON.stringify

    JSON only supports double-quotes.




    const mySelf = {
        firstName: 'Frank',
        lastName: 'Aboagye'
    }

    const strJSON  = JSON.stringify(mySelf);

    console.log(strJSON)

    const mySchool = {
        "theName": "Ashesi",
        "location": "Berekuso"
    }

    const objJSON = JSON.parse(strJSON)

    console.log(objJSON)






    // arrow functions

    const doubleNumber = (x) => {
        return x * x ;
    }

    console.log(doubleNumber(2))


    // short hand -> when it immediately returns something

    const doubleNumber2 = (x) => x * x ;

    console.log(doubleNumber2(3))


    // this -- bind 
    they work well for everything except methods






    const eventHub = {
        theName : "Birthday Party",
        guestList : ["Joel", "Princess", "Spencer"],
        printGuestList(){
            console.log('Guest for the ', this.theName);
            this.guestList.forEach((theGuest)=>{
                console.log(theGuest + ' is attending ' + this.theName);
            })
        }

    }

    eventHub.printGuestList()





    // find 

    const appUsers = [
        {name: "Princess", country: "USA"},
        {name: "Derby", country: "Canada"},
        {name: "Ivy", country: "China"},
    ]

    const theUser = appUsers.find((user) => user.name == "Derby");

    console.log(theUser);  // { name: 'Derby', country: 'Canada' }




    // debugger


    const appUsers = [
        {name: "Princess", country: "USA"},
        {name: "Derby", country: "Canada"},
        {name: "Ivy", country: "China"},
    ]

    const theUser = appUsers.find((user) => user.name == "Derby");

    debugger   // this will pause the debug session - unless you continue - ie. play it

    console.log(theUser);  // { name: 'Derby', country: 'Canada' }

    // use .exit to exit the debugger




    // error

    // some error(s)  is/are part of the stack track



    // async 

    // setTimeout - func that allows you to run your code after a specific amount of time has passed

    console.log("starting...");

    setTimeout(()=>{
        console.log('3 seconds timer');
    }, 3000)

    console.log("stopping")

    // result
    starting...
    stopping
    3 seconds timer

    
    the reason for this behaviour is that, setTimeout, is asynchronous and non-blocking
    - it doesnt block any node js code from running 



    // request 

    npm i request@2.88.0


    free Dark Sky API 
    account = 


    newAccount.!#1




    const request = require('request');

    const options = {
    method: 'GET',
    url: 'https://dark-sky.p.rapidapi.com/%7Blatitude%7D,%7Blongitude%7D',
    qs: {
        units: 'auto',
        lang: 'en'
    },
    headers: {
        'X-RapidAPI-Key': '4438067c3fmshc30e3ecb21f2cf4p1dca3ejsn44e7ece90c0f',
        'X-RapidAPI-Host': 'dark-sky.p.rapidapi.com'
    }
    };

    request(options, function (error, response, body) {
        if (error) throw new Error(error);

        console.log(body);
    });






    const request = require('request');

    const options = {
    method: 'POST',
    url: 'https://gowa.p.rapidapi.com/lookup/titmdb_id',
    qs: {
        id: '496243',
        type: 'movie',
        country: 'us'
    },
    headers: {
        'content-type': 'application/x-www-form-urlencoded',
        'X-RapidAPI-Key': '4438hc30e3ecb21f2cf4p1dca3ejsn44e7ece90c0f',
        'X-RapidAPI-Host': 'gowatapidapi.com'
    },
    fom: {
        id: '4963',
        type: 'move',
        country: 'uss'
    }
    };

    request(options, function (error, response, body) {
        if (error) {
            let theError = error ;
            
            throw new Error(error)
        };

        debugger

        console.log(body);
    });








    // call back

    - func passed as an argument to another function






    const geocode = (address, callback) =>{
        setTimeout(() => {
            const data = {
                latitude: 2909,
                longitude: 0
            };

            callback(data);
            
        }, 2000);
    }

    geocode('Ghana', (data)=>{
        console.log( data);
    })

    console.log("......")




    // call back abstraction






    // property shorthand

    const country = "Canada";

    const firstName = "Frank"

    const mySelf = {
        firstName : firstName,
        lastName : "Aboagye",
        age: 21,
        contry : country,
    }

    console.log(mySelf)

        // short hand

    const mySelf2 = {
        firstName,
        lastName : "Aboagye",
        age: 21,
        country
    }

    // same result 
    { firstName: 'Frank', lastName: 'Aboagye', age: 21, contry: 'Canada' }


    // object destructuring 

    Object destructuring gives you a syntax 
    for pulling properties off of objects and into standalone variables



    const mySelf = {
        firstName : "Frank",
        lastName : "Aboagye",
        age : 21,
        country:  "Ghana"
    }

    // destructure 

    const {age} = mySelf
    const {age:theAge} = mySelf

    const {firstName: theFirstName, lastName, country:theCountry} = mySelf

    console.log(`
    This is the info: 
    first name = ${theFirstName}
    last name  = ${lastName}
    country = ${theCountry}
    `)

    This is the info:
    first name = Frank
    last name  = Aboagye
    country = Ghana





    // an object can be destructured into a function

    const products = {
        productName: "Bag of rice",
        label: 2201,
        price: 99.99,
        currency: "$"
    }

    const buyIt = (type, {productName, price, currency}) =>{
        console.log(`
        For Purchase type  = ${type}
        Name of Product = ${productName}
        Price = ${currency} ${price} only
        `)
    }

    buyIt("Thialand", products)


    // result

    For Purchase type  = Thialand
    Name of Product = Bag of rice
    Price = $ 99.99 only







    // creating web server with express
    const express = require('express');

    const app = express();

    app.get('', (req, res)=>{
        res.send("Hello...");
    })

    app.get('/weather', (req, res)=>{
        res.send("Ghana hot")
    })


    app.listen(3000, ()=>{
        console.log("server running on port 3000");
    })




    // you can send more than text - HTML, JSON






    const express = require('express');

    const app = express();

    app.get('', (req, res)=>{
        res.send('<h2>This is working</h2>')
    })

    app.get('/weather', (req, res)=>{
        res.send({
            forecast: "Very Hot",
            location: "Ghana"
        })
    })


    app.listen(3000, ()=>{
        console.log('server running on port 3000');
    })



    // serving pages

    // All Express needs is the path to the directory it should serve






    const path = require('path');

    const express = require('express');

    const app = express();

    const publicDirPath = path.join(__dirname, '../public');

    app.use(express.static(publicDirPath));

    app.get('', (req, res)=>{
        res.send("<h1>Current Status</h1>")
    });

    app.get('/weather', (req, res)=>{
        res.send({
            mode: "working...",
            status: "active"
        });
    })


    app.listen(3000, ()=>{
        console.log('server running on port 3000')
    })





    // set up the Handlerbars templating engine with Express

    npm i hbs@4.0.1


    By default, Express expects your views to live in a views directory inside of your project 
    root.







    const express = require('express')

    const app = express() 

    app.set('view engine', 'hbs')

    app.get('/',  (req, res)=>{
        res.send("Working ...")
    })

    app.get('/viewPage', (req, res)=>{
        res.send({
            name : "frank",
            school : "ashesi"
        })
    })

    app.get('/viewWeb', (req, res)=>{
        res.render('index.hbs', {
            title: "Web page",
            name : "Frank Aboagye"
        })
    })'

    app.listen(3000, ()=>{
        console.log("Server running on port 3000")
    })








    // set the views - customise the view 

    const express = require('express');
    const path = require('path')

    const app = express()

    const theFilePath = path.join(__dirname, '/templates')  // we have successfully chnage it

    app.set('view engine', 'hbs')
    app.set('views', theFilePath)

    app.get('/', (req, res)=>{
        res.send("working...")
    })

    app.get('/viewPage', (req, res)=>{
        res.render('index',{
            title : "My Self",
            firstName : "Frank",
            lastName : "Aboagye"
        })
    })

    app.listen(3000, ()=>{
        console.log('server running at port 3000')
    })






    ===============


    {{!-- <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>{{ title }}</title>
    </head>
    <body>

        my name is {{ firstName }} {{ lastName }}
        
    </body>
    </html> --}}

    ==============




    // Handlerbars partials


    artials are great for things you need to show on 
    multiple pages like headers, footers, and navigation bars.



    // Partials are created with the “hbs” file extension


    // the header partial renders the title which can be shown at the top of every page.

    // The partial can then be rendered on a page using {{>header}}





    const hbs = require('hbs');

    const path = require('path');

    const express = require('express');

    const partialsPath = path.join(__dirname, '/templates')

    hbs.registerPartials(partialsPath);

    const app = express();

    app.set('view engine', 'hbs');

    app.set('views', partialsPath)

    app.get('/',(req, res)=>{
        res.send("working fine");
    });

    app.get('/viewPage', (req, res)=>{
        res.render('index', {
            webPageTitle : "Frank's Title",
            webPageName : "Frank's Web Page",
            appOwner : "Frank Kwabena Aboagye",
            year : 2023
        });
    });

    app.listen(3000, ()=>{
        console.log("server running on port 3000")
    });






    // 404 pages

    //  the * can be used to create a route handler that matches all requests
    // The 404 page should be set up just before the call to app.listen







    const express = require('express');

    const hbs = require('hbs');

    const path = require('path');

    const app = express();

    const anotherPath  = path.join(__dirname, '/templates');

    app.set('view engine', 'hbs');
    app.set('views', anotherPath);

    app.get('/', (req, res)=>{
        res.send("working");
    });

    app.get('*', (req, res)=>{
        res.render('404', {
            title : 404,
            name : "Frank Aboagye",
            errorMessage : "Page Not Found"
        });
    });

    app.listen(3000, ()=>{
        console.log('server running on port 3000');
    });



//===================================================

/*


    Accessing API from Browse

    setting up client and server  via HTTP requests


    use query strings to pass data from the client to the 
    server

    query string is a portion of the URL that allows you to provide additional information to 
    the serve

    g comes after this => 

    Express route handler can access the query string key/value pairs on req.query

    e.g http://localhost:3000/weather?address=philadelphia&units=us

    use req.query.address  === to get the value of the address


*/

const express = require('express');

const app = express();

app.get('/myself', (req, res)=>{
    res.send({
        firstname : req.query.firstName,
        surname : req.query.lastName
    });
});

app.listen(3000, ()=>{
    console.log('server running on port 3000')
});



// http://127.0.0.1:3000/myself/?firstName=frank&lastName=Aboagye

// {"firstname":"frank","surname":"Aboagye"}








// Building a JSON HTTP Endpoint



ES6 provides a new syntax to set default values for function arguments.

Function parameters are undefined unless an argument value is provided when the 
function is called




const greeting  = (salutation="Hello", username="Frank") =>{
    console.log(salutation, username, "!! Nice Meeting you");
};


greeting();




const transaction = (type, { label, stock = 0 } = {}) => {
    console.log(type, label, stock)
   }

transaction('fruits')  // fuits undefined 0









//  Browser HTTP Requests with Fetch



make  HTTP AJAX requests from the browser
fetch expects to be called with the URL as the first 
argument. It sends off the HTTP request and gives you back the response.




fetch().then((response)=>{
    response.json().then((data)=>{
        if (data.error){
            console.log(data.error);
        }else{
            console.log(data.location);
            console.log(data.forecast);
        }
    })
})

//==============


const express = require('express');

const app = express();

app.get('/', (req, res)=>{
    res.send("working ...")
});

app.get('/mySelf', (req, res)=>{
    res.send({
        data: "This is for myself",
        message : "my self "
    });
});

app.get('*', (req, res)=>{
    res.send({
        data : "No data",
        message : "Page not founc"
    });
});

app.listen(3000, ()=>{
    console.log('server running on port 3000')
});


// client.js

fetch('http://127.0.0.1:3000/mySel').then((response)=>{
    response.json().then((data)=>{
        if (data.message){
            console.log("The message is ", data.message);
        }
    });
});







// creating a form search

const express = require('express');

const hbs = require('hbs');


const path = require('path');

const anotherPath = path.join(__dirname, '/templates');

const app = express();

// app.set('view engine', 'html');

app.set('views', anotherPath);

app.get('/', (req, res)=>{
    res.send({
        theStatus : "working"
    });
});

app.get('/searchItem', (req, res)=>{

    res.render('/templates/theSeach.html');

});


// 

//

app.listen(3000, ()=>{
    console.log("server running on port 3000");
});



// wiring up interface 

const message = "This is for testing";
const sectionSelector = document.querySelector("#message");
sectionSelector.textContent = message;


// delpoying 



// heroku cli

heroku -v
heroku login


// git 
// ignore node modules

git status
git add 
git commit -m ""



// ssh 



ssh-keygen -t rsa -b 4096 -C "youremail@domain.com"

ssh-add ~/.ssh/id_rsa


. Robo 3T is a MongoDB admin tool that makes it easy 
to manage and visualize the data in your database

https://robomongo.org/



// mongodb://localhost:27017


// mongo db

// a database is made up of collections, and collections are used to store documents
const mongodb = require('mongodb');

const MongoClient = mongodb.MongoClient;

const connectionURL = 'mongodb://localhost:27017';

const databaseName = 'taskManager';

MongoClient.connect(connectionURL, {useNewUrlParser: true}, (error, client)=>{
    if(error){
        return console.log("Unable to connect to the db");
    }
    const db = client.db(databaseName);
    console.log("connection started");
});



*/
//  “users” collection
// db.collection is used to get a reference to the collection
// insertOne is used to insert a new document into that collection

// insertOne
// insertMany




const mongodb  = require('mongodb');

const MongoClient = mongodb.MongoClient;

const connectionURL = 'mongodb://localhost:27017';

const daatabaseName = 'taskManager2';

MongoClient.connect(connectionURL, {useNewUrlParser: true}, (error, client)=>{
    if (error){
        return console.log('unable to connect to the database');
    }
    
    const db = client.db(daatabaseName);
    console.log("the connection started...");


    db.collection('users').insertMany([
        {
            name: "frankaboagye",
            age: 21
        },
        {
            name: "ben",
            age: 23
        }
    ]);


})


// MongoDB provides ObjectID which can be used to generate new ObjectIDs


const {MongoClient, ObjectID} = require('mongodb');

const theID = new ObjectID();

console.log(theID) // MongoDB provides ObjectID which can be used to generate new ObjectIDs


// query - (find, findOne)




const mongodb = require('mongodb');

const MongoClient = mongodb.MongoClient;

const connectionURL = 'mongodb://localhost:27017';

const daatabaseName = 'taskManager2';

MongoClient.connect(connectionURL, {useNewUrlParser: true}, (error, client)=>{
    if(error){
        return console.log("unable to connect to the database");
    }
    
    const db = client.db(daatabaseName);
    console.log("the connection has started");

    db.collection('users').find({name: "frankaboagye"}).toArray((error, user)=>{
        console.log(user);
    });

})





const {MongoClient, ObjectID} = require('mongodb');


const connectionURL = 'mongodb://localhost:27017';

const daatabaseName = 'taskManager2';

MongoClient.connect(connectionURL, {useNewUrlParser: true}, (error, client)=>{
    if(error){
        return console.log("unable to connect to the database");
    }
    
    const db = client.db(daatabaseName);
    console.log("the connection has started");

    db.collection('users').find({name: "frankaboagye"}).toArray((error, user)=>{
        console.log(user);
    });

    db.collection('users').findOne({_id: new ObjectID('655b4a8944bf4ab8d8cf1583') }, (error, theUser)=>{
        console.log(theUser);
    })

})


