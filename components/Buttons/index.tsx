import { Pressable, StyleSheet, Text, View } from "react-native";

import { lines, linesWithActions, linesWithNumbers } from "./lines";
import { tintColorAccent } from "@/constants/Colors";
import { CLEAR, CLEAR_ALL, EQUAL } from "@/constants/buttons/actions";

import { Button, ButtonComponent, ButtonLine } from "@/types/buttons";

export default function Buttons({
  error,
  hasValue,
  isPortrait,
  onPress,
}: Readonly<ButtonComponent>) {
  const styles = StyleSheet.create({
    container: {
      flex: 0.8,
      flexDirection: isPortrait ? "column" : "row",
    },
    numbersContainer: {
      flex: 1,
    },
    actionsContainer: {
      flex: isPortrait ? 0 : 1,
    },
    lineContainer: {
      flex: 1,
      flexDirection: "row",
    },
    buttonContainer: {
      flex: 1,
      justifyContent: "center",
      alignItems: "center",
    },
    buttonTextAccent: {
      fontSize: isPortrait ? 28 : 20,
      color: tintColorAccent,
    },
    buttonTextWhite: {
      fontSize: isPortrait ? 28 : 20,
      color: "white",
    },
  });

  const renderItem = (item: Button) => {
    const isClearAllButton = item.action === CLEAR && !hasValue;
    const isEqualDisabled = item.action === EQUAL && !hasValue;
    const isErrorDisabled = item.action !== CLEAR && error;

    return (
      <Pressable
        key={item.id}
        style={styles.buttonContainer}
        disabled={isEqualDisabled || isErrorDisabled}
        onPress={() =>
          onPress(isClearAllButton ? { ...item, action: CLEAR_ALL } : item)
        }
      >
        <Text
          style={
            !!item.action ? styles.buttonTextWhite : styles.buttonTextAccent
          }
        >
          {isClearAllButton ? "AC" : item.name}
        </Text>
      </Pressable>
    );
  };

  return (
    <View style={styles.container}>
      {isPortrait ? (
        <>
          {lines.map((line: ButtonLine, index) => (
            <View key={`${line[0].id}-${index}`} style={styles.lineContainer}>
              {line.map(renderItem)}
            </View>
          ))}
        </>
      ) : (
        <>
          <View style={styles.actionsContainer}>
            {linesWithActions.map((line: ButtonLine, index) => (
              <View key={`${line[0].id}-${index}`} style={styles.lineContainer}>
                {line.map(renderItem)}
              </View>
            ))}
          </View>
          <View style={styles.numbersContainer}>
            {linesWithNumbers.map((line: ButtonLine, index) => (
              <View key={`${line[0].id}-${index}`} style={styles.lineContainer}>
                {line.map(renderItem)}
              </View>
            ))}
          </View>
        </>
      )}
    </View>
  );
}
