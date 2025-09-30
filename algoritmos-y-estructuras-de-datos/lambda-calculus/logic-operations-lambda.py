# Basic lambda definitions
TRUE = lambda x: lambda y: x
FALSE = lambda x: lambda y: y

def to_python_bool(lambda_bool):
    return lambda_bool(True)(False)

# Logic AND
AND = lambda p: lambda q : p (q) (FALSE)

resultado = AND(FALSE)(FALSE)
print(to_python_bool(resultado))
