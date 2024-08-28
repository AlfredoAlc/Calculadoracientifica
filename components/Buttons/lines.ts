import { ButtonLine, ButtonLines } from "@/types/buttons";
import {
  ABS,
  ADD,
  ARCCOS,
  ARCSINE,
  ARCTAN,
  CLEAR,
  COS,
  CUBIC_ROOT,
  DEG,
  DIVIDE,
  E,
  E_POW_X,
  EQUAL,
  FACTORIAL,
  HYPOTENUSE,
  INVERSE,
  INVERT_FRACTION,
  LN,
  LOG,
  MULTIPLY,
  PERCENTAGE,
  PI,
  POINT,
  POW,
  POW_CUBIC,
  POW_SQUARE,
  RAD,
  RAND,
  SIN,
  SQUARE_ROOT,
  SUBSTRACT,
  TAN,
  TEN_POW_X,
  Y_ROOT,
} from "@/constants/buttons/actions";

const line1: ButtonLine = [
  {
    id: "btn-c",
    name: "C",
    action: CLEAR,
  },
  {
    id: "btn-inverse",
    name: "⁺/₋",
    action: INVERSE,
  },
  {
    id: "btn-square-root",
    name: "²√",
    action: SQUARE_ROOT,
  },
  {
    id: "btn-divide",
    name: "÷",
    action: DIVIDE,
  },
];

const line2: ButtonLine = [
  {
    id: "btn-7",
    name: "7",
    value: 7,
  },
  {
    id: "btn-8",
    name: "8",
    value: 8,
  },
  {
    id: "btn-9",
    name: "9",
    value: 9,
  },
  {
    id: "btn-multiply",
    name: "×",
    action: MULTIPLY,
  },
];

const line3: ButtonLine = [
  {
    id: "btn-4",
    name: "4",
    value: 4,
  },
  {
    id: "btn-5",
    name: "5",
    value: 5,
  },
  {
    id: "btn-6",
    name: "6",
    value: 6,
  },
  {
    id: "btn-substract",
    name: "-",
    action: SUBSTRACT,
  },
];

const line4: ButtonLine = [
  {
    id: "btn-1",
    name: "1",
    value: 1,
  },
  {
    id: "btn-2",
    name: "2",
    value: 2,
  },
  {
    id: "btn-3",
    name: "3",
    value: 3,
  },
  {
    id: "btn-add",
    name: "+",
    action: ADD,
  },
];

const line5: ButtonLine = [
  {
    id: "btn-0",
    name: "0",
    value: 0,
  },
  {
    id: "btn-point",
    name: "⋅",
    action: POINT,
  },
  {
    id: "btn-percentage",
    name: "%",
    action: PERCENTAGE,
  },
  {
    id: "btn-equal",
    name: "=",
    action: EQUAL,
  },
];

const lineTopActions: ButtonLine = [
  {
    id: "btn-log",
    name: "log",
    action: LOG,
  },
  {
    id: "btn-ln",
    name: "ln",
    action: LN,
  },
  {
    id: "btn-cubic-root",
    name: "³√",
    action: CUBIC_ROOT,
  },
  {
    id: "btn-rand",
    name: "rand",
    action: RAND,
  },
];

const lineAction1: ButtonLine = [
  {
    id: "btn-invert-fraction",
    name: "¹/ₓ",
    action: INVERT_FRACTION,
  },
  {
    id: "btn-pow-square",
    name: "x²",
    action: POW_SQUARE,
  },
  {
    id: "btn-pow-cubic",
    name: "x³",
    action: POW_CUBIC,
  },
  {
    id: "btn-factorial",
    name: "x!",
    action: FACTORIAL,
  },
];

const lineAction2: ButtonLine = [
  {
    id: "btn-deg",
    name: "deg",
    action: DEG,
  },
  {
    id: "btn-hyp",
    name: "hyp",
    action: HYPOTENUSE,
  },
  {
    id: "btn-sin",
    name: "sin",
    action: SIN,
  },
  {
    id: "btn-arcsin",
    name: "sin⁻¹",
    action: ARCSINE,
  },
];
const lineAction3: ButtonLine = [
  {
    id: "btn-rad",
    name: "rad",
    action: RAD,
  },
  {
    id: "btn-pow",
    name: "^",
    action: POW,
  },
  {
    id: "btn-cos",
    name: "cos",
    action: COS,
  },
  {
    id: "btn-arccos",
    name: "cos⁻¹",
    action: ARCCOS,
  },
];
const lineAction4: ButtonLine = [
  {
    id: "btn-pi",
    name: "π",
    action: PI,
  },
  {
    id: "btn-euler",
    name: "e",
    action: E,
  },
  {
    id: "btn-tan",
    name: "tan",
    action: TAN,
  },
  {
    id: "btn-arctan",
    name: "tan⁻¹",
    action: ARCTAN,
  },
];
const lineAction5: ButtonLine = [
  {
    id: "btn-abs",
    name: "abs",
    action: ABS,
  },
  {
    id: "btn-y-root",
    name: "ʸ√ₓ",
    action: Y_ROOT,
  },
  {
    id: "btn-ten-pow-x",
    name: "10ˣ",
    action: TEN_POW_X,
  },
  {
    id: "btn-euler-pow-x",
    name: "eˣ",
    action: E_POW_X,
  },
];

export const linesWithNumbers: ButtonLines = [
  lineTopActions,
  line1,
  line2,
  line3,
  line4,
  line5,
];

export const linesWithActions: ButtonLines = [
  lineAction1,
  lineAction2,
  lineAction3,
  lineAction4,
  lineAction5,
];

export const lines: ButtonLines = [line1, line2, line3, line4, line5];
