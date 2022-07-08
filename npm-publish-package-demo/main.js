export const printHelloMessage = (customMessage="") => {
    if(customMessage.length === 0){
        console.log("Hello `npm publish`")
        return;
    }
    console.log(customMessage);
}