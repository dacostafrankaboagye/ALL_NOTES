
/*

types

+++ js
number
string
boolean
null
undefined
object

+++ TS

any
unknown
never
enum
tuple


+++ type inference

*/


let a = 9; // knows that a is of tupe number 

// tuples
let user: [number, string]  = [1, "ab"]






// enum
    // use the enum to group constants



const enum Size  {small, medium, large} ; // default small-> 0, medium-> 1, large -> 2

//using const on the enum
    // this is the js code - let abenaShirt = 2 // Size.large ;
    // without the enum -> the code will be very 'cody
    // using const makes the code more optmised


    let abenaShirt: Size = Size.large

    console.log(abenaShirt);





// functions
    // anotate them
function calculateIndexPrice(priceTag: number): void{
    priceTag += 4;
    console.log("Price is ", priceTag)
}

// making parameter optional
function mySelf(firstName: string, middleName?: string, lastname?: string): string{
    // let fullname: string = firstName + " ";
    // if(middleName){
    //     fullname += middleName;
    // }
    // if(lastname){
    //     fullname += " " + lastname;
    // }
    // return fullname;

    let fullname: string = firstName + "-" + ((middleName || " md ")) + "-" +  ((lastname || " ln "));

    return fullname;

}

// default value
function getName(theName: string ="abc"): void{
    console.log(theName);
}




// objects

let employee:{id: number, firstname: string} = {id: 1, firstname: "abena"}
let employee2:{id: number, firstname?: string} = {id: 1}

// read only modifier
let employeee:{ readonly id: number, firstname?: string} = {id: 1}
// readonly - now you cannot modify the id

// even with functions
let employeee3:{ 
    readonly id: number, 
    firstname?: string,
    addTwo: (a:number) => void
} = {
    id: 1,
    firstname: "frank",
    addTwo: (a)=>{
        console.log(a+2)
    }}



// type aliases 

type Employee = {
    readonly id: number, 
    firstname?: string,
    addTwo: (a:number) => void
}

let employeee3: Employee = {
    id: 1,
    firstname: "frank",
    addTwo: (a)=>{
        console.log(a+2)
    }}





    // union
    // (0°C × 9/5) + 32 

function celciusToFarenheit(degree: number | string):number{
    let result: number;
    if(typeof degree === 'number'){
        result = (degree * (9/5)) + 32;
    }
    else{
        result = parseInt(degree);
    }
    return result;
}

console.log(celciusToFarenheit(10))





// type intersection

type Draggable = {
    toLeft: () => void;
}

type Resizable = {
    size: () => void;
}

type UIWidget = Draggable & Resizable;

let textBox: UIWidget = {
    toLeft: () => {},
    size: () => {}
}



// literal types
    // exact or specific value

type Quantity = 50 | 100;
type Metric = 'cm' | "inch";
let bagOfRice: Quantity = 100;  // bag of rice can only be 50 or 100


// nullable types
    // use the union operator 

function greet(name: string | null | undefined ): void{
    if(name){
        console.log("Helloo", name);
    }else{
        console.log("Hola");
    }
}

greet(null);
greet("frank");



// optional chaining

type Customer = {
    birthDay: Date;
}

function getCustomer(id: number): Customer | null | undefined{
    return id === 0 ? null : {birthDay: new Date};
}

let customer = getCustomer(2);

// since the getCustomer() can return null 
if (customer !== null && customer !== undefined){
    console.log(customer.birthDay);
    
}

// instead of the above - you can use the optional property access operator: "?."
console.log(customer?.birthDay)// only executes if the customer id not null or if the customer is not undefined

// use it any time there is a possibility that, there will be a null or undefined








// making the birthday property optional
type Customer = {
    birthDay?: Date;
}

function getCustomer(id: number): Customer | null | undefined{
    return id === 0 ? null : {birthDay: new Date};
}

let customer = getCustomer(0);

if (customer !== null && customer !== undefined){
    console.log(customer.birthDay?.getFullYear);
    
}

console.log(customer?.birthDay?.getFullYear)

// optional element access operator 
// use for array - say you have a customer array
// if(customer !== null && customer !== undefined)
// customer?.[0]



// optional call operator 
// example say fnx is log : any = null;
// log?.('a')  // if it accepts a prameter or returns null



