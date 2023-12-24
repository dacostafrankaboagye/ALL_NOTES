/*
npm create vite@latest 
npm create vite@4.1.0 
npm run dev

npm i bootstrap@5.2.3


// function based component and class component
function based component have become popular

- Pascal casing - use it

//JSX - JavaScript XML
 it is going to be complied to JS

go to babeljs.io/repl

*/

function App(){
  return (
    <div>
      <Message>
        
      </Message>
    </div>
  );
}

or

// self closing - more consice


function App(){
  return (
    <div>      
      <Message/>
    </div>
  );
}


/*

- A component cannot return more than one element
    - you can use div - as a wrapper 
    - a better way - use fragment - import it
    - instead of the fragment - use <> </>
        - empty tags



*/

import { Fragment } from "react";

function ListGroup(){
    return (
        <Fragment>
            <h1>This is Good</h1>
            <ul className="list-group">
                <li className="list-group-item">An item</li>
                <li className="list-group-item">A second item</li>
                <li className="list-group-item">A third item</li>
                <li className="list-group-item">A fourth item</li>
                <li className="list-group-item">And a fifth one</li>
            </ul>
        </Fragment>
    )
}


// or

        <>
            <h1>This is Good</h1>
            <ul className="list-group">
                <li className="list-group-item">An item</li>
                <li className="list-group-item">A second item</li>
                <li className="list-group-item">A third item</li>
                <li className="list-group-item">A fourth item</li>
                <li className="list-group-item">And a fifth one</li>
            </ul>
        </>

export default ListGroup;







// rendering list

function ListGroup() {
  const items = ["New York", "San Francisco", "Tokyo", "Londo", "Paris"];

  return (
    <>
      <h1>This is Good</h1>
      <ul className="list-group">
        {items.map((item) => (
          <li className="list-group-item">{item}</li>
        ))}
      </ul>
    </>
  );
}

export default ListGroup;




/*
// using the key

// warning - each list of item should have a unique key  prop
- it will uniquely identify the item

<li key={item} className="list-group-item">{item}</li>


++++++++++++++++++++++++++++++++++++++++++++++

// conditional rendering 

*/
function ListGroup() {
  let items = ["New York", "San Francisco", "Tokyo", "Londo", "Paris"];
 

  if(items.length === 0){
    return (
        <>
            <h1>List</h1>
            <p>No items Available</p>
        </>
    );
  }

  return (
    <>
      <h1>This is Good</h1>
      <ul className="list-group">
        {items.map((item) => (
          <li key={item} className="list-group-item">{item}</li>
        ))}
      </ul>
    </>
  );
}

export default ListGroup;


// to this :::

function ListGroup() {
  
  let items = ["New York", "San Francisco", "Tokyo", "Londo", "Paris"];
  items = []
  

  return (
    <>
      {items.length === 0 ?  <p>No Item</p>  : null}
      {items.length === 0 && <p>No Item</p> }

      <ul className="list-group">
        {items.map((item) => (
          <li key={item} className="list-group-item">{item}</li>
        ))}
      </ul>

    </>
  );
}

/*
::: 
you can put:
{items.length === 0 ? "No Items" : null} 
in a function or constant


      {items.length === 0 ?  <p>No Item</p>  : null}
      {/* {items.length === 0 && <p>No Item</p> }  - works in JS */}


+++++++++++++++++++++++++++++++++++++++++++

Handling eEvent
  
*/
<li key={item} className="list-group-item" onClick={(event)=>{console.log(event)}}>{item}</li>

/*
by convention - we start the function with 
"handle"


  const handleClick = (event) => {console.log(event)}

  // this will result in a type script error

  hover over the event and look at the type: it did not give any error inside
  of the in line command: this:*/

            <ul className="list-group">
              {items.map((item, index) => (
                <li key={item} className="list-group-item" onClick={(event)=>{console.log(event)}}>{item}</li>
              ))}
            </ul>

{/* we see it is React.MouseEvent */}


import { MouseEvent } from "react";
  const handleClick = (event:MouseEvent) => {console.log(event)}

   <li key={item} className="list-group-item" onClick={handleClick}>{item}</li>

{/* 


++++++++++++++++++++++++++++++++++++++++++

Managing State

- say we want to highlight / make active (from Bootstrap) a selected element:


but this does not work yet ??  */}

function ListGroup() {
  
  let items = ["New York", "San Francisco", "Tokyo", "Londo", "Paris"];

  let selectedIndex = 0;  

  return (
    <>

      {items.length === 0 && <p>No Item</p> }

      <ul className="list-group">
        {items.map((item, index) => (
          <li 
            key={item} 
            className={selectedIndex === index ? 'list-group-item active' : 'list-group-item'}
            onClick={()=>{selectedIndex = index}}
          >
            
            {item}
            
          </li>
        ))}
      </ul>

    </>
  );
}

export default ListGroup;

{/* 

we need to tell react that the "selectedIndex" variable is going to be a 
state that will be changing 


use a Hook -> e.g: state Hook

it allows us to touch some built in features of react


note

const arr = useState(theInitialNumber)
arr[0]  = will be == variable
arr[1] = will be == updater function

e.g 
const [name, setName] = useState('');




the solution to that:
 */}
import { useState } from "react";




function ListGroup() {
  
  let items = ["New York", "San Francisco", "Tokyo", "Londo", "Paris"];

  // let selectedIndex = 0; 
  const [selectedIndex, setSelectedIndex] = useState(0)

  return (
    <>

      {items.length === 0 && <p>No Item</p> }

      <ul className="list-group">
        {items.map((item, index) => (
          <li 
            key={item} 
            className={selectedIndex === index ? 'list-group-item active' : 'list-group-item'}
            onClick={()=>{setSelectedIndex(index)}}
          >
            
            {item}
            
          </li>
        ))}
      </ul>

    </>
  );
}

export default ListGroup;




{/* 
note: 
- each component will have its own state


+++++++++++++++++++++++++++++++++++++++++++++++

Passing Data vis Props

- input to components
- it make component - reusable 

instead of defining this:
  let items = ["New York", "San Francisco", "Tokyo", "Londo", "Paris"];

  we should be able to pass them to the component

using interface -
we can define the shape or the interface of an object



the structure
items: [] 
heading: string


convention - 
say the name of the function is : ListGroup

we will write : 

interface ListGroupProps {
  items: string[];
  heading: string;
}



we can do this::: */}

import { useState } from "react";

interface ListGroupProps {
  items: string[];
  heading: string;
}


function ListGroup(props:ListGroupProps) {

  // let selectedIndex = 0; 
  const [selectedIndex, setSelectedIndex] = useState(0)

  return (
    <>

      {props.items.length === 0 && <p>No Item</p> }

      <ul className="list-group">
        {props.items.map((item, index) => (
          <li 
            key={item} 
            className={selectedIndex === index ? 'list-group-item active' : 'list-group-item'}
            onClick={()=>{setSelectedIndex(index)}}
          >
            
            {item}
            
          </li>
        ))}
      </ul>

    </>
  );
}




{/* or desturcture it : since we are using props.something a lot */}





import { useState } from "react";

interface ListGroupProps {
  items: string[];
  heading: string;
}


function ListGroup({items, heading}:ListGroupProps) {

  // let selectedIndex = 0; 
  const [selectedIndex, setSelectedIndex] = useState(0)

  return (
    <>

      {items.length === 0 && <p>No Item</p> }

      <h1>{heading}</h1>

      <ul className="list-group">
        {items.map((item, index) => (
          <li 
            key={item} 
            className={selectedIndex === index ? 'list-group-item active' : 'list-group-item'}
            onClick={()=>{setSelectedIndex(index)}}
          >
            
            {item}
            
          </li>
        ))}
      </ul>

    </>
  );
}

export default ListGroup;


{/* 
++++++++++++++++++++++++++++++++++++


Passing function via props

say, we want the app component to be aware that, an Item has been selected



by convvention: start with "on"

e.eg. onSelectedItem




in the app component 
 */}

import ListGroup from "./components/ListGroup";

const handleSelectedItem = (item: string) => {console.log(item)}
function App() {
  let items = ["New York", "San Francisco", "Tokyo", "Londo", "Paris"];
  return (
    <div>
      <ListGroup items={items} heading="Cities" onSelectedItem={handleSelectedItem}/>
    </div>

  );
}

export default App;




{/* in the list group component */}


import { useState } from "react";

interface ListGroupProps {
  items: string[];
  heading: string;
  // the signature (item: string) => void
  onSelectedItem: (item:string) => void;
}


function ListGroup({items, heading, onSelectedItem}:ListGroupProps) {

  // let selectedIndex = 0; 
  const [selectedIndex, setSelectedIndex] = useState(0)

  return (
    <>

      {items.length === 0 && <p>No Item</p> }

      <h1>{heading}</h1>

      <ul className="list-group">
        {items.map((item, index) => (
          <li 
            key={item} 
            className={selectedIndex === index ? 'list-group-item active' : 'list-group-item'}
            onClick={()=>{
              setSelectedIndex(index);
              onSelectedItem(item);
            }}
          >
            
            {item}
            
          </li>
        ))}
      </ul>

    </>
  );
}

export default ListGroup;





{/* 





++++++++++++++++++++



state vs Props



props
- input passed into a component
  - like a function argument 
- treat them as immutable : read only : un-changeable 



state
- data managed by a component 
  - like a local variable 
- mutable 
  - the data can change 



Both state and prop can cause a re-render 



++++++++++++++++++++++++++++++++++++++++++++++++++++


passing children 

""""" Extension : ES7+

INSTALL it

shortcut : rafce

(it stand for: react arrow function component export )

- you will get a code snippet 





from this::::


 */}


import Alert from "./components/Alert";


function App(){
  return (
    <div>

      <Alert text="My Alert"/>

    </div>
  )
}

export default App;


{/* 

to :::  */}



interface AlertProp {
    text: string;
}
// a covention that all interfaces support  - childern

const Alert = ({text}:AlertProp) => {
  return (
    <div className="alert alert-primary">{text}</div>
  )
}

export default Alert;




{/* 

:::: using children


 */}
interface AlertProp {
    children: string;
}
// a covention that all interfaces support  - childern

const Alert = ({children}:AlertProp) => {
  return (
    <div className="alert alert-primary">{children}</div>
  )
}

export default Alert;







import Alert from "./components/Alert";


function App(){
  return (
    <div>

      <Alert>
        My Primary Alert
      </Alert>

    </div>
  )
}

export default App;

{/* 
but now we cannot pass an HTML into it:

___not possible __

      <Alert>
        <span>My Primary Alert</span>
      </Alert>
the children is of type string

it is not possible 


use ReactNode 
- there are two types - becareful 


 */}

import { ReactNode } from "react";

interface AlertProp {
    children: ReactNode;
}

// a covention that all interfaces support  - childern

const Alert = ({children}:AlertProp) => {
  return (
    <div className="alert alert-primary">{children}</div>
  )
}

export default Alert;

{/* 
now we can do this:::



 */}
import Alert from "./components/Alert";


function App(){
  return (
    <div>

      <Alert>
        <h1>My Primary Alert</h1> 
      </Alert>

    </div>
  )
}

export default App;


{/* 


+++++++++++++++++++++

use Rect Developer Tools Extension 
- for inspecting and analysing react application


go to the inspect -  and go to components -> to see the hierarchy
you can see the matching dom element 



++++++++++++++++++++++++++++++++++


creating a button component


 */}
import Button from "./components/Button";

function App(){
  return (

    <Button text="My Nice Button" onButtonClick={()=>{console.log("clicked")}} />

  )
}

export default App;





interface ButtonProp{
    text: string;
    onButtonClick: () => void;
    color ?: string;
}

const Button = ({text, onButtonClick, color="primary"}: ButtonProp) => {
  return (
    <button 
        className={"btn btn-" + color}
        onClick={onButtonClick}
    >
        {text}
    </button>
  )
}

export default Button;

