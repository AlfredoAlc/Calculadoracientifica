import {
  ADD,
  DEG,
  DIVIDE,
  HYPOTENUSE,
  MULTIPLY,
  POW,
  SUBSTRACT,
  Y_ROOT,
} from "@/constants/buttons/actions";

import { ActionType, GradeType } from "@/types/utils/actions";

const calculateTotal = (
  number: number,
  total: number,
  action: ActionType
): number => {
  switch (action) {
    case ADD:
      return handleAdd(number, total);
    case DIVIDE:
      return handleDivide(number, total);
    case MULTIPLY:
      return handleMultiply(number, total);
    case SUBSTRACT:
      return handleSubstract(number, total);
    case HYPOTENUSE:
      return handleHypotenuse(number, total);
    case POW:
      return handlePow(number, total);
    case Y_ROOT:
      return handleYRoot(number, total);
    default:
      return 0;
  }
};

export const handleAdd = (
  number: number,
  total: number,
  prevAction?: ActionType
): number => {
  if (prevAction && prevAction !== "")
    return calculateTotal(number, total, prevAction);
  return total + number;
};

export const handleDivide = (
  number: number,
  total: number,
  prevAction?: ActionType
): number => {
  if (prevAction && prevAction !== "" && total !== 0)
    return calculateTotal(number, total, prevAction);
  else if (total === 0) return number;
  else return total / number;
};

export const handleMultiply = (
  number: number,
  total: number,
  prevAction?: ActionType
): number => {
  if (prevAction && prevAction !== "" && total !== 0)
    return calculateTotal(number, total, prevAction);
  else if (total === 0) return number;
  else return total * number;
};

export const handleSubstract = (number: number, total: number): number => {
  if (total < 0 || number < 0) return handleAdd(number, total);
  else if (total > 0) return total - number;
  else return number;
};

export const handleEqual = (
  number: number,
  total: number,
  prevAction?: ActionType
): number => {
  if (prevAction) return calculateTotal(number, total, prevAction);
  else return total;
};

export const handleSquareRoot = (number: number): number => {
  return Math.sqrt(number);
};

export const handleInvertFraction = (number: number): number => {
  return Math.pow(number, -1);
};

export const handlePowSquare = (number: number): number => {
  return Math.pow(number, 2);
};

export const handlePowCubic = (number: number): number => {
  return Math.pow(number, 3);
};

export const handleFactorial = (number: number): number => {
  let i = number - 1;
  for (i; i > 0; i--) {
    number *= i;
  }
  return number;
};

export const handleLog = (number: number): number => {
  return Math.log10(number);
};

export const handleLn = (number: number): number => {
  return Math.log(number);
};

export const handleCubicRoot = (number: number): number => {
  return Math.cbrt(number);
};

export const handleRandom = () => {
  return Math.random();
};

export const handleHypotenuse = (number: number, total: number): number => {
  return Math.hypot(number, total);
};

export const handleSine = (number: number, grade: GradeType) => {
  const radians = grade === DEG ? number * (Math.PI / 180) : number;
  return Math.sin(radians);
};

export const handleArcSine = (number: number, grade: GradeType) => {
  const radians = Math.asin(number);
  return grade === DEG ? radians * (180 / Math.PI) : radians;
};

export const handlePow = (number: number, total: number): number => {
  return Math.pow(total, number);
};

export const handleCosine = (number: number, grade: GradeType) => {
  const radians = grade === DEG ? number * (Math.PI / 180) : number;
  return Math.cos(radians);
};

export const handleArcCosine = (number: number, grade: GradeType) => {
  const radians = Math.acos(number);
  return grade === DEG ? radians * (180 / Math.PI) : radians;
};

export const handlePi = () => {
  return Math.PI;
};

export const handleEuler = () => {
  return Math.E;
};

export const handleTan = (number: number, grade: GradeType) => {
  const radians = grade === DEG ? number * (Math.PI / 180) : number;
  return Math.tan(radians);
};

export const handleArcTan = (number: number, grade: GradeType) => {
  const radians = Math.atan(number);
  return grade === DEG ? radians * (180 / Math.PI) : radians;
};

export const handleAbs = (number: number): number => {
  return Math.abs(number);
};

export const handleYRoot = (number: number, total: number): number => {
  return Math.pow(total, 1 / number);
};

export const handleTenPowX = (number: number): number => {
  return Math.pow(10, number);
};

export const handleEPowX = (number: number): number => {
  return Math.exp(number);
};
