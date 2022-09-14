fs = require("node:fs"); // fs = FileSystem
fsPromise = fs.promises;
path = require("node:path");
readline = require("node:readline");


process.on("uncaughtException", error => {
    console.error("An uncaught exception was thrown.")
    console.error(error);
})

const filePath = path.join(__dirname, "filesToCheck", "testCode.js");

async function run(){
    const fileContent = await fsPromise.readFile(filePath, "UTF8")

    console.log(fileContent);
}

run();