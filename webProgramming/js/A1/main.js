// Wasim Singh
// SYST10199 Web Programming
// Cristo Vasilaros A1 


// A1 - Object and arrays
// Create an array of objects that describe a classroom of 2 students. Each 
// student has a firstName, lastName, and GPA and a set of 3 courses. 
// Each course has a name and a grade. 
//Please ensure the data structure you create is free of errors. Use this tool to test it:
// https://jsonformatter.curiousconcept.com/


// as js objects
classroom = [

    {
        firstName: Cristo,
        lastName: Vasilaros,
        gpa: 4.0,
        courses: [
            {
                courseName: "Java",
                grade: 99
            },
            {
                courseName: "Web Programming",
                grade: 99
            },
            {
                courseName: "Linux",
                grade: 99
            }

        ]
    },

    {
        firstName: notCristo,
        lastName: aVasilaros,
        gpa: 4.0,
        courses: [
            {
                courseName: "Java",
                grade: 9
            },
            {
                courseName: "Web Programming",
                grade: 9
            },
            {
                courseName: "Linux",
                grade: 9
            }

        ]
    }

]

// as json data
"classroom"[
    {
        "firstName": "Cristo",
        "lastName": "Vasilaros",
        "gpa": 4.0,
        "courses": [
            {
                "courseName": "Java",
                "grade": 99
            },
            {
                "courseName": "Web Programming",
                "grade": 99
            },
            {
                "courseName": "Linux",
                "grade": 99
            }
        ]
    },
    {
        "firstName": "notCristo",
        "lastName": "aVasilaros",
        "gpa": 4.0,
        "courses": [
            {
                "courseName": "Java",
                "grade": 9
            },
            {
                "courseName": "Web Programming",
                "grade": 9
            },
            {
                "courseName": "Linux",
                "grade": 9
            }
        ]
    }
]