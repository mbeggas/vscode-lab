import pytest
from sums_positive_nmb import sum_positive_numbers

def test_sum_positive_numbers():
    # حالة طبيعية (جميع الأعداد موجبة)
    assert sum_positive_numbers([1, 2, 3, 4, 5]) == 15

    # قائمة تحتوي على صفر
    assert sum_positive_numbers([0, 10, 20]) == 30

    # قائمة تحتوي على عدد واحد موجب
    assert sum_positive_numbers([7]) == 7

    # قائمة فارغة (يجب أن تُرجع 0)
    assert sum_positive_numbers([]) == 0

    # حالة تحتوي على عدد سالب (يجب أن ترمي استثناء)
    try:
        sum_positive_numbers([1, -2, 3])
    except ValueError as e:
        assert str(e) == "القائمة تحتوي على أعداد سالبة!"
    else:
        assert False, "لم يتم رفع الاستثناء كما هو متوقع!"
