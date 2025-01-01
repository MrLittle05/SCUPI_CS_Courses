# INFSCI0310 Computation in Information Science
# Department of Computer Science, SCUPI

# Assignment 3: Linear Regression
# Due on: Wednesday, December 11th, 23:59 pm

Welcome to assignment 3, where you need to build a linear regression model from scratch to predict house prices. <br>


# Data files for this assignment
In order to get hand on the assignment, you have to download the data files and allocate them into the correct directory as follows:

```
├── [your working directory]
   ├── house.csv
```

**Please make sure to use the correct path to these files when working on your own machine. Recall that the jupyter *.ipynb file (this assignment file) should be in your working directory.**

# 1. Theory Preparation

In order to build the linear regression model from scratch, you need to review/prepare the theories: <br>
1. The Math notations to use, together with their sizes/dimensionalities. <br>
2. The expression to compute the loss values, assume we are using MSE to evaluate the loss. <br>
3. The expression to compute the gradients of parameters, assume we are using gradient descent to optimize the model. <br>


### <font color='red'>Exercise 1 (20 marks) </font>
Now we state:
* $\boldsymbol{X}\in\mathbb{R}^{d\times n}$ as the feature set, $\boldsymbol{y}\in\mathbb{R}^{1\times n}$ as the ground truth house prices. <br>
* $\boldsymbol{w}\in\mathbb{R}^{d\times 1}$ as the weight vector, $b$ is the bias scalar <br>
* $L$ is the MSE loss value

As you might realize we have already helped you with the Math notations, please complete the left two tasks, and justify your answer by presenting the computational processes or any proofs related. The left two tasks are: <br>
1. The expression to compute the loss values, assume we are using MSE to evaluate the loss. <br>
2. The expression to compute the gradients of parameters, assume we are using gradient descent to optimize the model. 

**Note**: <font color='red'>Exercise 1 is the foundation of this assignment, fatal mistakes will lead to a 20% deduction of your total mark for the whole assignment.</font> <br>
**Note**: your expressions should only include the notations we gave, in other words, you need to complete these tasks using a very compact vector/matrix form. Meaning that there should not exist notations such as $\boldsymbol{x}_{i}$ or $y_{i}$ <br>
**Note**: we **only accept** jupyter Markdown answers, answers come from Word, PDF, or photos taken from an actual A4 paper, are **NOT valid**. <br>
**Note**: wrong format of Math notations (italic, bold) will **NOT** be counted as fatal mistakes, however, you need to assue the correctness of any computational flows in your answer. <br>
**Hint**: for the bias $b$, you can use $b\cdot\boldsymbol{1}$ to fit the vector/matrix form, where $\boldsymbol{1}\in\mathbb{R}^{1\times n}$.


```python
# For Exercise 1, please change this cell to a Markdown cell

```

# 2. Data and Model

After knowing these computations from a foudamental level, we can code the linear regression task now, but before that, let's load and view the data:


```python
import pandas as pd
house = pd.read_csv('./house.csv', header=0)
print(house)
```

          Order        PID  MS SubClass MS Zoning  Lot Frontage  Lot Area Street  \
    0         1  526301100           20        RL         141.0     31770   Pave   
    1         2  526350040           20        RH          80.0     11622   Pave   
    2         3  526351010           20        RL          81.0     14267   Pave   
    3         4  526353030           20        RL          93.0     11160   Pave   
    4         5  527105010           60        RL          74.0     13830   Pave   
    ...     ...        ...          ...       ...           ...       ...    ...   
    2925   2926  923275080           80        RL          37.0      7937   Pave   
    2926   2927  923276100           20        RL           NaN      8885   Pave   
    2927   2928  923400125           85        RL          62.0     10441   Pave   
    2928   2929  924100070           20        RL          77.0     10010   Pave   
    2929   2930  924151050           60        RL          74.0      9627   Pave   
    
         Alley Lot Shape Land Contour  ... Pool Area Pool QC  Fence Misc Feature  \
    0      NaN       IR1          Lvl  ...         0     NaN    NaN          NaN   
    1      NaN       Reg          Lvl  ...         0     NaN  MnPrv          NaN   
    2      NaN       IR1          Lvl  ...         0     NaN    NaN         Gar2   
    3      NaN       Reg          Lvl  ...         0     NaN    NaN          NaN   
    4      NaN       IR1          Lvl  ...         0     NaN  MnPrv          NaN   
    ...    ...       ...          ...  ...       ...     ...    ...          ...   
    2925   NaN       IR1          Lvl  ...         0     NaN  GdPrv          NaN   
    2926   NaN       IR1          Low  ...         0     NaN  MnPrv          NaN   
    2927   NaN       Reg          Lvl  ...         0     NaN  MnPrv         Shed   
    2928   NaN       Reg          Lvl  ...         0     NaN    NaN          NaN   
    2929   NaN       Reg          Lvl  ...         0     NaN    NaN          NaN   
    
         Misc Val Mo Sold Yr Sold Sale Type  Sale Condition  SalePrice  
    0           0       5    2010       WD           Normal     215000  
    1           0       6    2010       WD           Normal     105000  
    2       12500       6    2010       WD           Normal     172000  
    3           0       4    2010       WD           Normal     244000  
    4           0       3    2010       WD           Normal     189900  
    ...       ...     ...     ...       ...             ...        ...  
    2925        0       3    2006       WD           Normal     142500  
    2926        0       6    2006       WD           Normal     131000  
    2927      700       7    2006       WD           Normal     132000  
    2928        0       4    2006       WD           Normal     170000  
    2929        0      11    2006       WD           Normal     188000  
    
    [2930 rows x 82 columns]
    

This dataset was collected over several years for the city of Ames, Iowa. As you can see, there are a lot of features to look, to make this assignment simpler, we focus on a subset of this dataset, *house_filtered*:


```python
house_filtered = house[(house['Bldg Type']=='1Fam') & (house['Sale Condition']=='Normal')]
house_filtered = house_filtered[['SalePrice','1st Flr SF', '2nd Flr SF', 'Total Bsmt SF', 'Garage Area', 'Wood Deck SF', 'Open Porch SF', 'Lot Area', 'Year Built', 'Yr Sold']]
print(house_filtered)
```

          SalePrice  1st Flr SF  2nd Flr SF  Total Bsmt SF  Garage Area  \
    0        215000        1656           0         1080.0        528.0   
    1        105000         896           0          882.0        730.0   
    2        172000        1329           0         1329.0        312.0   
    3        244000        2110           0         2110.0        522.0   
    4        189900         928         701          928.0        482.0   
    ...         ...         ...         ...            ...          ...   
    2925     142500        1003           0         1003.0        588.0   
    2926     131000         902           0          864.0        484.0   
    2927     132000         970           0          912.0          0.0   
    2928     170000        1389           0         1389.0        418.0   
    2929     188000         996        1004          996.0        650.0   
    
          Wood Deck SF  Open Porch SF  Lot Area  Year Built  Yr Sold  
    0              210             62     31770        1960     2010  
    1              140              0     11622        1961     2010  
    2              393             36     14267        1958     2010  
    3                0              0     11160        1968     2010  
    4              212             34     13830        1997     2010  
    ...            ...            ...       ...         ...      ...  
    2925           120              0      7937        1984     2006  
    2926           164              0      8885        1983     2006  
    2927            80             32     10441        1992     2006  
    2928           240             38     10010        1974     2006  
    2929           190             48      9627        1993     2006  
    
    [2002 rows x 10 columns]
    

## <font color='red'>Exercise 2 (15 marks) </font>
In *house_filtered*, the data column *SalePrice* denotes the house prices that require prediction, other data columns are features. <br>
In this exercise, you need to take a deeper look into the data, answer the following questions, code analysis and demonstrations to justify your answer:

1. Do you think the house prices in *house_filtered* are suitably distributed to construct the regression model?
2. Any features that you want to remove from the dataset? If yes, please point out the column names of these features.
3. Any pre-processing you would like to apply on *house_filtered*? If yes, please state the reason and proceed your pre-processing for the next step of usage.


```python
# For Exercise 2

```

## <font color='red'>Exercise 3 (65 marks) </font>
After a preview of the data, you should move to this stage, i.e., implement your model and optimize its parameters to learn how to perform the regression task, i.e., predict house prices. <br>
In this exercise, you need to complete the following tasks: <br>

1. Split your data into features $\boldsymbol{X}\in\mathbb{R}^{d\times n}$, and targets (ground truth house prices) $\boldsymbol{y}\in\mathbb{R}^{1\times n}$. Initialize your regression model, i.e., the weight vector $\boldsymbol{w}\in\mathbb{R}^{d\times 1}$ and the bias value $b$ **(10 marks)**.
2. Build the computations you have discovered in **Exercise 1**, these computations will lead you to the MSE loss values and the gradients **(25 marks)**.
3. Apply gradient descents to train your regression model, iteratively update the parameters, i.e., the weight vector $\boldsymbol{w}\in\mathbb{R}^{d\times 1}$ and the bias value $b$. To simplify things, use all the data in each iteration of gradient descent **(10 marks)**.
4. Decide when to stop the optimization process (the gradient descent) and answer why do you want to stop the training here **(5 marks)**.
5. In the end, please summarize the regression performance of your regression model. How would you comment on such model performance? Use text to describe where you can improve the performance of the model and the rationality behind such improvements **(15 marks)**.

**Note**: <font color='red'>Please DO NOT use any Python libraries embedded with linear regression or gradient descent, you need to stick with basic functionalities of Numpy to code all computational processes, failed to comply with this will lead to an immediate 0 marks for Exercise 3.</font> <br>
**Note**: for simplicity, here you should focus only on the training stage and use all the data for training purposes. <br>
**Note**: you may want to explain the regression performance using the unit of "house prices".


```python
# For Exercise 3

```

### <font color='blue'>Submission</font>

You only need to submit the jupyter file in **ipynb** format, rename it as: A3_YOURID_YOURNAME (For instance: A3_2023141520000_Sofia) <br>


```python

```
