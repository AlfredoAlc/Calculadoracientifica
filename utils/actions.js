import {
  ADD,
  DIVIDE,
  MULTIPLY,
  SUBSTRACT,
} from "@/constants/buttons/actions";

const calculateTotal = (number, total, action) => {
  switch (action) {
    case ADD:
      return handleAdd(number, total)
    case DIVIDE:
      return handleDivide(number, total)
    case MULTIPLY:
      return handleMultiply(number, total)
    case SUBSTRACT:
      return handleSubstract(number, total)
    default:
      return;
  }
}

export const handleAdd = (number, total, prevAction) => {
  if (prevAction && prevAction !== '')
    return calculateTotal(number, total, prevAction);
  return total + number
}

export const handleDivide = (number, total, prevAction) => {
  if (prevAction && prevAction !== '' && total !== 0)
    return calculateTotal(number, total, prevAction)
  else if (total === 0)
    return number
  else
    return total / number
}

export const handleMultiply = (number, total, prevAction) => {
  if (prevAction && prevAction !== '' && total !== 0)
    return calculateTotal(number, total, prevAction)
  else if (total === 0)
    return number
  else
    return total * number
}

export const handleSubstract = (number, total) => {
  if (total < 0 || number < 0)
    return handleAdd(number, total)
  else if (total > 0)
    return total - number
  else
    return number
}

export const handleEqual = (number, total, prevAction) => {
  if (prevAction)
    return calculateTotal(number, total, prevAction);
  else
    return total;
}

export const handleSquareRoot = (number) => {
  return Math.sqrt(number)
}