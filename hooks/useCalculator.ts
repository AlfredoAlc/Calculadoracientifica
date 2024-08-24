import {
  ADD,
  CLEAR,
  CLEAR_ALL,
  CUBIC_ROOT,
  DIVIDE,
  EQUAL,
  FACTORIAL,
  INVERSE,
  INVERT_FRACTION,
  LN,
  LOG,
  MULTIPLY,
  PERCENTAGE,
  POINT,
  POW_CUBIC,
  POW_SQUARE,
  RAND,
  SQUARE_ROOT,
  SUBSTRACT,
} from "@/constants/buttons/actions";
import {
  handleInvertFraction,
  handlePowCubic,
  handlePowSquare,
  handleAdd,
  handleDivide,
  handleEqual,
  handleMultiply,
  handleSquareRoot,
  handleSubstract,
  handleFactorial,
  handleLog,
  handleLn,
  handleCubicRoot,
  handleRandom,
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

export default function useCalculator(isDegrees: boolean) {
  const [currentNumber, setCurrentNumber] = useState<number>(0);
  const [error, setError] = useState<boolean>(false);
  const [hasDecimalPoint, setHasDecimalPoint] = useState<boolean>(false);
  const [prevAction, setPrevAction] = useState<PrevAction>(defaultPrevAction);

  const total = useRef(defaultTotal);

  const handleError = (result: any) => {
    if (isNaN(result)) setError(true);
    else setCurrentNumber(result);
  };

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
        total.current = {
          value: handleDivide(
            currentNumber,
            total.current.value,
            total.current.prevAction
          ),
          prevAction: button.action,
        };
        setPrevAction({ name: button.name, action: button.action });
        setCurrentNumber(0);
        break;

      case MULTIPLY:
        total.current = {
          value: handleMultiply(
            currentNumber,
            total.current.value,
            total.current.prevAction
          ),
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
        handleError(handleSquareRoot(currentNumber));
        break;

      case SUBSTRACT:
        total.current = {
          value: handleSubstract(currentNumber, total.current.value),
          prevAction: button.action,
        };
        setPrevAction({ name: button.name, action: button.action });
        setCurrentNumber(0);
        break;

      case LOG:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handleLog(currentNumber));
        break;

      case LN:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handleLn(currentNumber));
        break;

      case CUBIC_ROOT:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handleCubicRoot(currentNumber));
        break;

      case RAND:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handleRandom());
        break;

      case INVERT_FRACTION:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handleInvertFraction(currentNumber));
        break;

      case POW_SQUARE:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handlePowSquare(currentNumber));
        break;

      case POW_CUBIC:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handlePowCubic(currentNumber));
        break;

      case FACTORIAL:
        total.current = defaultTotal;
        setPrevAction({ name: button.name, action: button.action });
        handleError(handleFactorial(currentNumber));
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
