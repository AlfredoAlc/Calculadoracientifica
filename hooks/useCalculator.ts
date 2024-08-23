import {
  ADD,
  CLEAR,
  CLEAR_ALL,
  DIVIDE,
  EQUAL,
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

type TotalLocal = {
  value: number;
  prevAction: string;
};

type PrevAction = {
  action: string;
  name: string;
};
const defaultTotal: TotalLocal = { value: 0, prevAction: "" };

const defaultPrevAction: PrevAction = { action: "", name: "" };

export default function useCalculator() {
  const [currentNumber, setCurrentNumber] = useState<number>(0);
  const [error, setError] = useState<boolean>(false);
  const [hasDecimalPoint, setHasDecimalPoint] = useState<boolean>(false);
  const [prevAction, setPrevAction] = useState<PrevAction>(defaultPrevAction);

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
        setPrevAction({ name: button.name, action: button.action });
        setCurrentNumber(0);
        break;

      case CLEAR:
        setPrevAction(defaultPrevAction);
        setCurrentNumber(0);
        break;

      case CLEAR_ALL:
        total.current = defaultTotal;
        setError(false);
        setPrevAction(defaultPrevAction);
        setCurrentNumber(0);
        break;

      case DIVIDE:
      case MULTIPLY:
        total.current = {
          value: currentNumber,
          prevAction: button.action,
        };
        setPrevAction({ name: button.name, action: button.action });
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
        setPrevAction({ name: button.name, action: button.action });
        break;

      case INVERSE:
        setPrevAction(defaultPrevAction);
        setCurrentNumber((prev) => -prev);
        break;

      case PERCENTAGE:
        setPrevAction(defaultPrevAction);
        setCurrentNumber((prev) => prev / 100);
        break;

      case POINT:
        if (!currentNumber.toString().includes(".")) {
          setPrevAction(defaultPrevAction);
          setHasDecimalPoint(true);
        }
        break;

      case SQUARE_ROOT:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        const result = handleSquareRoot(currentNumber);
        if (isNaN(result)) setError(true);
        else setCurrentNumber(result);
        break;

      case SUBSTRACT:
        total.current = {
          value: handleSubstract(currentNumber, total.current.value),
          prevAction: button.action,
        };
        setPrevAction({ name: button.name, action: button.action });
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
    prevAction,
    calculate,
    setHasDecimalPoint,
    setCurrentNumber,
  };
}
