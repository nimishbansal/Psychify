import pandas as pd
from sklearn.cross_validation import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score
from sklearn.svm import SVC

dataset = pd.read_csv("data.csv")
print(len(dataset))
del dataset["elapse"]
for i in range(len(dataset)):
    print(i)
    dataset.iloc[i, 0] = int(dataset.iloc[i, 0] / 10)

X = dataset.values[:, 1:]
y = dataset.values[:, 0]

X_train, X_test, y_train, y_test = train_test_split(X, y)

clf = SVC()
clf.fit(X_train, y_train)
y_pred = clf.predict(X_test)
print(accuracy_score(y_test, y_pred))
