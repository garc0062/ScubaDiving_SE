# Scuba Diving Calculation Assistant

## Specifications
This will be a GUI application that allows for modification of the data through a drawing
application.
It should be an application that will accept user input and display the Maximum Operating
Depth (MOD) or, the "Best Mix" (BM) for a certain dive, or the Partial Pressure (PP) of O2,
or the Equivalent Air Depth (EAD) for the requested inputs. In addition the application will
be able to produce tables for Equivalent Air Depths and Partial Pressures.

## Simple Calculations
Your program should ensure that all inputs and outputs are within the acceptable range and
are suitable for the calculation selected. Furthermore, the user should not be concerned about
upper or lower case entries where text input is required. Errors should be handled `gracefully'
and messages should inform the user of the mistake and supply adequate opportunity to either
correct the error, or perform another calculation.
The Help menu item should give instructions for the acceptable use of the program and the
meaning of the menu items.

## Complex Calculations
The client also requires that two tables be produced. The first is an Equivalent Air Depth Table
that will show the EAD's for a start and end percentage of Oxygen and a start and end depth.
The client only requires percentages of Oxygen from 18% to 50%, or any combinations within
that range, in increments of 1%, and depths from 3 metres to 70 metres, or any combinations
within that range, in increments of 3 metres. The second is a Table of Partial Pressures using
the same requirement for input as the EAD Table, but any partial pressure above 1.6 should
not be displayed. In addition the end values for both the Oxygen content and the depths are to
be larger than the start values. These calculations should be added as menu items and produce
the required output.

## GUI Design Specifications
You are being given freedom in the design of this interface, but the client wants the following
included:
  Somewhere...
  - For the user to specify the percentage of Oxygen
  - For the user to specify the partial pressure of Oxygen
  - For the user to specify the depth (in metres)
  - To enable the user to select the type of (simple) calculation to perform EAD / MOD / Best Mix / PP / SMOD
  - To display the result of any of the calculations
  - For a drawing space where a cylinder be drawn by the application showing the percentage of Oxygen and Nitrogen in the mixture. This should be dynamic with a change in the percentage of Oxygen be immediately translated to the graphic.
  - For the start and end percentages of Oxygen and depths for the complex calculations
  - To select which table to produce
  - For a suitable representation of the tabular output

### Google Drive Link
https://drive.google.com/drive/folders/1IVU17s1Xtf0CCB_-R5qTUjyKs7tIfMY8
