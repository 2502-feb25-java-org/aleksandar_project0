//JavaScript Coding Challenge 2 Week 1
//Aleksandar Antonov

//return the nth fibonacci number

challenge_fibonacci = function (n) {
    var a = 1, b = 0, temp;
    while (n > 0) {
        temp = a;
        a = a + b;
        //console.log(b);
        b = temp;
        n--;
    }
    console.log(b);
    return b;
};

//take an array of integers and return the sorted array

challenge_sort = function (array) {
    var swap;
    var count = array.length - 1;

    for (let i = 0; i < count; i++) {
        for (let j = 0; j < array.length; j++) {
            if (array[j] > array[j + 1]) {
                swap = array[j + 1];
                array[j + 1] = array[j];
                array[j] = swap;
            }
        }
    }
    return array;
};


