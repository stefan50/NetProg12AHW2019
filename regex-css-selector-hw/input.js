regExps = {
"exercise_1": /[A-Z][a-z]+/,
"exercise_2": /088[1-9]{7}/,
"exercise_3": /[^0-1]+/,
"exercise_4": /^[a-zA-Z._0-9]{3,14}$/,
"exercise_5": /^[0-9]{0,3}$|1[0-4][0-9]{2}|1500/,
"exercise_6": /class=[""''][a-z A-Z]+[''""]/
};
cssSelectors = {
"exercise_1": "item > java",
"exercise_2": "java.diffClass",
"exercise_3": "java + tag.class2",
"exercise_4": "css > item:last-of-type",
"exercise_5": "tag > java:nth-child(2)",
"exercise_6": "item:empty.class1, item:empty.class2",
"exercise_7": "different#diffId2 > java:last-of-type",
"exercise_8": "css > item:nth-last-of-type(2)"
};


