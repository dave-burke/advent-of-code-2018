# Advent of Code 2018

[![Build Status](https://travis-ci.com/dave-burke/advent-of-code-2018.svg?branch=master)](https://travis-ci.com/dave-burke/advent-of-code-2018)

These are my solutions to the [Advent of Code 2018](https://adventofcode.com/2018) challenge.

## Usage

```sh
./run.sh [day number] [part number]
```

The `main` function in `App` will execute the code for a given day based on input in `src/main/resources/day[number].txt`

The given `Day` class will process the input and return a result, which `App` will print to `stdout`.

## Testing

Each day has a unit test. It can be used to process the sample input given on the Advent of Code web site. That way the
process can be built using TDD.
