import { ButtonLine, ButtonLines } from "@/types/buttons";
import {
  ADD,
  CLEAR,
  DIVIDE,
  EQUAL,
  INVERSE,
  MULTIPLY,
  PERCENTAGE,
  POINT,
  SQUARE_ROOT,
  SUBSTRACT,
} from "../../constants/buttons/actions";

const line1: ButtonLine = [
  {
    id: "btn-c",
    name: "c",
    action: CLEAR,
  },
  {
    id: "btn-inverse",
    name: "+/-",
    action: INVERSE,
  },
  {
    id: "btn-square-root",
    name: "√",
    action: SQUARE_ROOT,
  },
  {
    id: "btn-divide",
    name: "/",
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
    name: "X",
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
    name: ".",
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

export const lines: ButtonLines = [line1, line2, line3, line4, line5];
