import {
  ADD,
  CLEAR,
  CLEAR_ALL,
  DIVIDE,
  EQUAL,
  ERR,
  INVERSE,
  MULTIPLY,
  PERCENTAGE,
  POINT,
  SQUARE_ROOT,
  SUBSTRACT,
} from "@/constants/buttons/actions";
import {
  handleAdd,
  handleEqual,
  handleSquareRoot,
  handleSubstract,
} from "@/utils/actions";

import { Button } from "@/types/buttons";
import { useRef, useState } from "react";

type totalLocal = {
  value: number;
  prevAction: string;
};
const defaultTotal: totalLocal = { value: 0, prevAction: "" };

export default function useCalculator() {
  const [currentNumber, setCurrentNumber] = useState<number>(0);
  const [error, setError] = useState<boolean>(false);
  const [hasDecimalPoint, setHasDecimalPoint] = useState<boolean>(false);
  const [prevActionName, setPrevActionName] = useState<string>("");

  const total = useRef(defaultTotal);

  const calculate = (button: Button) => {
    switch (button.action) {
      case ADD:
        total.current = {
          value: handleAdd(
            currentNumber,
            total.current.value,
            total.current.prevAction
          ),
          prevAction: button.action,
        };
        setPrevActionName(button.name);
        setCurrentNumber(0);
        break;

      case CLEAR:
        setPrevActionName("");
        setCurrentNumber(0);
        break;

      case CLEAR_ALL:
        total.current = defaultTotal;
        setError(false);
        setPrevActionName("");
        setCurrentNumber(0);
        break;

      case DIVIDE:
      case MULTIPLY:
        total.current = {
          value: currentNumber,
          prevAction: button.action,
        };
        setPrevActionName(button.name);
        setCurrentNumber(0);
        break;

      case EQUAL:
        setCurrentNumber(
          handleEqual(
            currentNumber,
            total.current.value,
            total.current.prevAction
          )
        );
        total.current = defaultTotal;
        setPrevActionName(button.name);
        break;

      case INVERSE:
        setPrevActionName("");
        setCurrentNumber((prev) => -prev);
        break;

      case PERCENTAGE:
        setPrevActionName("");
        setCurrentNumber((prev) => prev / 100);
        break;

      case POINT:
        if (!currentNumber.toString().includes(".")) {
          setPrevActionName("");
          setHasDecimalPoint(true);
        }
        break;

      case SQUARE_ROOT:
        total.current = defaultTotal;
        setPrevActionName(button.name);
        const result = handleSquareRoot(currentNumber);
        if (isNaN(result)) setError(true);
        else setCurrentNumber(result);
        break;

      case SUBSTRACT:
        total.current = {
          value: handleSubstract(currentNumber, total.current.value),
          prevAction: button.action,
        };
        setPrevActionName(button.name);
        setCurrentNumber(0);
        break;

      default:
        return;
    }
  };

  return {
    currentNumber,
    error,
    hasDecimalPoint,
    prevActionName,
    calculate,
    setHasDecimalPoint,
    setCurrentNumber,
  };
}
