import { useRef, useState } from "react";
import { ScrollView, StyleSheet, Text, View } from "react-native";

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
import { useThemeColor } from "@/hooks/useThemeColor";
import Buttons from "@/components/Buttons";

import { Button } from "@/types/buttons";
import { tintColorAccent } from "@/constants/Colors";

type totalLocal = {
  value: number;
  prevAction: string;
};
const defaultTotal: totalLocal = { value: 0, prevAction: "" };

export default function HomeScreen() {
  const backgroundColor = useThemeColor({}, "background");

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      paddingTop: 60,
      backgroundColor,
    },
    scrollViewContainer: {
      flex: 0.2,
      transform: [{ scaleX: -1 }],
      alignContent: "flex-end",
    },
    textContainer: {
      paddingHorizontal: 20,
    },
    currentText: {
      color: "white",
      fontSize: 60,
      transform: [{ scaleX: -1 }],
      textAlignVertical: "bottom",
      textTransform: "uppercase",
    },
    prevActionText: {
      color: tintColorAccent,
      position: "absolute",
      fontSize: 30,
      top: 18,
      left: 18,
      transform: [{ scaleX: -1 }],
    },
  });

  const [currentNumber, setCurrentNumber] = useState<number>(0);
  const [error, setError] = useState<boolean>(false);
  const [hasDecimalPoint, setHasDecimalPoint] = useState<boolean>(false);
  const [prevActionName, setPrevActionName] = useState<string>("");

  const total = useRef(defaultTotal);

  const handleOnPress = (button: Button) => {
    if (typeof button.value !== "undefined") {
      let value = `${currentNumber}${button.value}`;
      if (hasDecimalPoint) {
        value = `${currentNumber}.${button.value}`;
        setHasDecimalPoint(false);
      }
      return setCurrentNumber(parseFloat(value));
    }

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

  const renderNumber = () => {
    try {
      return currentNumber !== 0
        ? currentNumber.toLocaleString("en-US", {
            maximumSignificantDigits: 10,
          })
        : "";
    } catch (err) {
      console.log("renderNumber error: ", err);
      setCurrentNumber(0);
      return "";
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.scrollViewContainer}>
        <Text style={styles.prevActionText}>{prevActionName}</Text>
        <ScrollView
          contentContainerStyle={styles.textContainer}
          directionalLockEnabled
          horizontal
          showsHorizontalScrollIndicator={false}
          overScrollMode="always"
        >
          <Text style={styles.currentText}>
            {error ? (
              ERR
            ) : (
              <>
                {renderNumber()}
                {hasDecimalPoint && "."}
              </>
            )}
          </Text>
        </ScrollView>
      </View>
      <Buttons
        onPress={handleOnPress}
        hasValue={currentNumber > 0 && !!total.current.prevAction}
        error={error}
      />
    </View>
  );
}
