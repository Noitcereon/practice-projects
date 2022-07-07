/* Table of Contents */

/* 
--- Variable setup ---
--- Common Console Commands ---
- console.log
- console.info
- console.warn
- console.error

--- Less Common Console Commands ---

- console.assert
- console.count
- console.table
- console.time / console.timeend
- console.clear

 */

const mainScript = () => {

    /* Variable Setup */

    let movieData = [
        {
            name: "Hooga Booga",
            releaseYear: 1989
        },
        {
            name: "Erantis Calopi",
            releaseYear: 1999
        },
        {
            name: "The Wheel of Time",
            releaseYear: 2020
        },
        {
            name: "Lord of the Rings: The Fellowship of the Ring",
            releaseYear: 2001
        }
    ]


    /* Common Console Commands */

    console.info("This is the Common Console Commands section");
    console.log(movieData, "console.log");
    console.info(movieData, "console.info");
    console.warn(movieData, "console.warn");
    console.error(movieData, "console.error");


    /* Less Common Console Commands */
    console.info("This is the Less Common Console Commands section");

    /* console.assert */
    console.info("console.assert")
    console.assert(movieData.length === 4, "movieData.length is not equal to 4"); // if it succeeds, no message is displayed
    console.assert(movieData.length === 0, "movieData.length is not equal to 0");

    /* console.count */
    console.info("console.count")
    const counter1 = "counter 1";
    const counter2 = "A different counter";
    console.count(counter1);
    console.count(counter1);
    console.count(counter2);
    console.count(counter1);

    /* console.table */
    console.info("console.table")
    console.table(movieData);
    console.info("Adding data to movieData");
    movieData.push({ name: "Incomplete movie", prizes: ["Incompleteness price", "Wow"] });
    console.table(movieData);

    /* console.time */
    console.info("console.time");
    console.info("Starting timer");
    console.time("Timer1");
    setTimeout(() => {

        console.info("Waited 2 seconds");
        console.timeEnd("Timer1");
        console.timeEnd("Timer 2");
    }, 2000)

    /* console.clear */

    // Just here to represent that you can set it to autoclear after an interval.
    // console.warn("Clearing console in 10 seconds");
    // setTimeout(() => {
    //     // Sends a message after clearing ("Console was cleared.")
    //     console.clear();
    // }, 1000 * 10);
}

mainScript();